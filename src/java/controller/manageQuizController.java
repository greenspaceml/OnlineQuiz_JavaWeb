/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author green
 */
public class manageQuizController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String error = (String) request.getAttribute("error");
            String pageIndexDelete = (String) request.getAttribute("pageIndex");
            QuestionDAO questionDAO = new QuestionDAO();
            //get the pageindex value
            String pageIndex = request.getParameter("index");
            //access manage Quiz in first time, the page index will be 1\
            if (pageIndexDelete != null) {
                pageIndex = pageIndexDelete;
            }
            if (pageIndex == null) {
                pageIndex = "1";
            }
            int index = 1;
            //try parsing pageindex from String to Integer
            try {
                index = Integer.parseInt(pageIndex);
            } catch (NumberFormatException e) {
                //if error when parsing, errorMessage will take the error String
                error = "Page not found";
            }

            int pageSize = 3;

            int totalQuestions = questionDAO.countQuestion();

            //get total page seach
            int pageCount = (totalQuestions % pageSize == 0) ? totalQuestions / pageSize : totalQuestions / pageSize + 1;

            //get news per page
            ArrayList<Question> listQuestions = questionDAO.pagedQuestion(index, pageSize);

            //check page valid
            if (totalQuestions > 0) {
                if (index > pageCount || (index < 1)) {

                    error = "Page not found";
                }
            }

            //send data to jsp
            request.setAttribute("totalQuestions", totalQuestions);
            request.setAttribute("listQuestions", listQuestions);
            request.setAttribute("index", index);
            request.setAttribute("pageCount", pageCount);
            request.setAttribute("error", error);
            request.getRequestDispatcher("manageQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
