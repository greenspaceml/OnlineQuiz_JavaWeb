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
import model.User;

/**
 *
 * @author green
 */
public class UserDAO {

    public User getUserByUsernameAndPassword(String username, String password) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User n = new User();
        //sql statement
        String sql = "Select * from Users where username = ? and password = ?";
        DBContext dBContext = new DBContext();
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                n.setId(rs.getString("id"));
                n.setUsername(rs.getString("username"));
                n.setPassword(rs.getString("password"));
                n.setEmail(rs.getString("email"));
                n.setType(rs.getBoolean("type"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return n;
    }

    public User getUserByUsername(String username) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User n = new User();
        //sql statement
        String sql = "Select * from Users where username = ?";
        DBContext dBContext = new DBContext();
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                n.setId(rs.getString("id"));
                n.setUsername(rs.getString("username"));
                n.setPassword(rs.getString("password"));
                n.setEmail(rs.getString("email"));
                n.setType(rs.getBoolean("type"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return n;
    }

    public boolean createNewUser(String username, String password, String email, int type) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int check = 0;
        //sql statement
        String sql = "insert into Users (username,password,email,type) values\n"
                + " (?,?,?,?)";
        DBContext dBContext = new DBContext();
        try {
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setInt(4, type);
            check = ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            dBContext.closeAll(connection, ps, rs);
        }
        return check > 0;
    }

}
