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

/**
 *
 * @author green
 */
public class prepareQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String message = null;
            
            //getnumber of quiz entered
            String numOfQuiz = request.getParameter("numOfQuiz");
            QuestionDAO questionDAO = new QuestionDAO();
            
            int totalQuiz = questionDAO.countQuestion();
            int quiz = 0;
            
            try {
                //check if the number of quiz is NUMBER or not
                quiz = Integer.parseInt(numOfQuiz);
                //check if number of question if fit or not
                if (quiz > totalQuiz) {
                    message = "The number of questions cannot be greater than " + totalQuiz;
                }
                if (quiz < 1 && totalQuiz > 0) {
                    message = "The number of questions cannot be less than 0";
                }
            } catch (Exception e) {
                message = "Please enter a number";
            }

            request.setAttribute("quiz", quiz);
            request.setAttribute("message", message);
            if (message == null) {
                request.getRequestDispatcher("takeQuiz").forward(request, response);
            } else {
                request.getRequestDispatcher("prepareQuiz.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
