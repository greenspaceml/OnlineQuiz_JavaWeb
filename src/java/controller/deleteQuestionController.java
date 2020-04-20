/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author green
 */
public class deleteQuestionController extends HttpServlet {

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
            String error = null;
            QuestionDAO questionDAO = new QuestionDAO();
            String delete = request.getParameter("delID");
            String index = request.getParameter("currentPage");
            int pageIndex = 1;
            int recordInPage = 0;
            if (index != null) {
                try {
                    pageIndex = Integer.parseInt(index);
                } catch (NumberFormatException e) {
                    pageIndex = 1;
                }
            }
            
            if (delete != null) {
                int questionID = 0;
                try {
                    questionID = Integer.parseInt(delete);
                } catch (NumberFormatException e) {
                    error = "Not found question";
                }
                boolean flag = questionDAO.deleteQuestion(questionID);

                if (!flag) {
                    error = "Not found question";
                }
                int numOfRecord = 3;
                recordInPage = questionDAO.countQuestionNumberInPage(pageIndex, numOfRecord);
                 if (recordInPage == 0) {
                    if (pageIndex == 1) {
                        pageIndex = 1;
                    }else{
                        pageIndex -= 1;
                    }
                }
                 
                request.setAttribute("error", error);
                request.setAttribute("pageIndex", pageIndex + "");
                request.getRequestDispatcher("manageQuiz").forward(request, response);
            }
        } catch (Exception e) {
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
