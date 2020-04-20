/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author green
 */
public class makeQuizController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String message = "";

            String content = request.getParameter("content");
            String option1 = request.getParameter("opt1");
            String option2 = request.getParameter("opt2");
            String option3 = request.getParameter("opt3");
            String option4 = request.getParameter("opt4");
            String[] answer = request.getParameterValues("answer");

            String strAnswer = "";

            //check answer checked
            String[] checkedAnswer = {"", "", "", ""};
            //
            if (answer != null) {
                for (int i = 0; i < answer.length; i++) {
                    //saving checked answers 
                    strAnswer += answer[i];
                }
                //check if every single option is checked or not, if Yes , checkedAnswer 's value is 'checked' else pass 
                if (strAnswer.contains("1")) {
                    checkedAnswer[0] = "checked";
                }
                if (strAnswer.contains("2")) {
                    checkedAnswer[1] = "checked";
                }
                if (strAnswer.contains("3")) {
                    checkedAnswer[2] = "checked";
                }
                if (strAnswer.contains("4")) {
                    checkedAnswer[3] = "checked";
                }
            }

            //check content
            if (content.trim().equals("")) {
                message = "Question content cannot be empty";
            } //check option 1
            else if (option1.trim().equals("")) {
                message = "Option 1 cannot be empty";
            } //check option 2
            else if (option2.trim().equals("")) {
                message = "Option 2 cannot be empty";
            } //check option 3
            else if (option3.trim().equals("")) {
                message = "Option 3 cannot be empty";
            } //check option 4
            else if (option4.trim().equals("")) {
                message = "Option 4 cannot be empty";
            } //check no answer
            else if (answer == null) {
                message = "Please select answer(s)";
            } //check all answer
            else if (answer != null && answer.length == 4) {
                message = "Cannot select all answers";
            }

            boolean isInsert = false;
            if (message.equals("")) {
                Question question = new Question(content, option1, option2, option3, option4, strAnswer);
                QuestionDAO questionDAO = new QuestionDAO();
                
                isInsert = questionDAO.insertQuestion(question);
                message = "Question added successfully";
            }

            request.setAttribute("isInsert", isInsert);
            request.setAttribute("message", message);
            
            request.setAttribute("content", content);
            request.setAttribute("opt1", option1);
            request.setAttribute("opt2", option2);
            request.setAttribute("opt3", option3);
            request.setAttribute("opt4", option4);
            request.setAttribute("answer", checkedAnswer);

            request.getRequestDispatcher("makeQuiz.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
