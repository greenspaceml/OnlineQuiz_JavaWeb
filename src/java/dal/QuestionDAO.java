/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Question;

/**
 *
 * @author green
 */
public class QuestionDAO {

    public int countQuestion() throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*) FROM Question";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return 0;
    }

    public ArrayList<Question> pagedQuestion(int pageIndex, int pageSize) throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> listQuestions = new ArrayList<>();

        String sql = "SELECT *\n"
                + "   FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY id DESC) as row_num \n"
                + "              FROM  Question) quiz\n"
                + "   where row_num >= ? and row_num <= ?";
        try {
            int firstQuestion = (pageIndex - 1) * pageSize + 1;
            int lastQuestion = pageIndex * pageSize;
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, firstQuestion);
            ps.setInt(2, lastQuestion);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question s = new Question();
                s.setId(rs.getString("id"));
                s.setContent(rs.getString("content"));
                s.setOption1(rs.getString("option1"));
                s.setOption2(rs.getString("option2"));
                s.setOption3(rs.getString("option3"));
                s.setOption4(rs.getString("option4"));
                s.setAnswer(rs.getString("answer"));
                s.setCreated(rs.getDate("created"));
                listQuestions.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return listQuestions;
    }

    public int countQuestionNumberInPage(int pageIndex, int pageSize) throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT count(*)\n"
                + "                FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY id DESC) as row_num\n"
                + "                FROM  Question) quiz\n"
                + "                where row_num >= ? and row_num <= ?";
        try {
            int firstQuestion = (pageIndex - 1) * pageSize + 1;
            int lastQuestion = pageIndex * pageSize;
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, firstQuestion);
            ps.setInt(2, lastQuestion);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return 0;
    }

    public boolean deleteQuestion(int id) throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "Delete from Question where id = ?";
        int check = 0;
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public boolean insertQuestion(Question question) throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int check = 0;
        String sql = "Insert into Question (content,option1,option2,option3,option4,answer) values\n"
                + "(?,?,?,?,?,?)";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, question.getContent());
            ps.setString(2, question.getOption1());
            ps.setString(3, question.getOption2());
            ps.setString(4, question.getOption3());
            ps.setString(5, question.getOption4());
            ps.setString(6, question.getAnswer());
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

    public ArrayList<Question> getRandomQuestion(int count) throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> listQuestions = new ArrayList<>();
        String sql = " Select top (?) *\n"
                + " from Question\n"
                + " order by NEWID()";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, count);
            rs = ps.executeQuery();
            while (rs.next()) {
                Question s = new Question();
                s.setId(rs.getString("id"));
                s.setContent(rs.getString("content"));
                s.setOption1(rs.getString("option1"));
                s.setOption2(rs.getString("option2"));
                s.setOption3(rs.getString("option3"));
                s.setOption4(rs.getString("option4"));
                s.setAnswer(rs.getString("answer"));
                s.setCreated(rs.getDate("created"));
                listQuestions.add(s);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return listQuestions;
    }
    
    
    public void insertQuizHistory(String userID, String srcore, String status) throws Exception {
        DBContext dBContext = new DBContext();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "insert into QuizHistory(userID,score,status) values\n"
                + " (?,?,?)";
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, srcore);
            ps.setString(3, status);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
    }
}
