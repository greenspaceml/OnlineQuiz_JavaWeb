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
import javax.servlet.http.HttpSession;
import model.Question;
import model.User;
import processSupport.Supporter;

/**
 *
 * @author green
 */
public class resultQuizController extends HttpServlet {

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
            QuestionDAO questionDAO = new QuestionDAO();
            HttpSession session = request.getSession();
            Supporter supporter = new Supporter();
            ArrayList<Question> listQuiz = (ArrayList<Question>) session.getAttribute("listQuiz");
            session.removeAttribute("listQuiz");
            int countTrue = 0;
            String message = null;
            String strScore = "";
            String status = "rejected";
            long ended = supporter.getCurrentTime();
            long endTime = (long) session.getAttribute("endTime");
            //delete session
            session.removeAttribute("endTime");
            //reject
            if (ended > endTime) {
                message = "Time up.";
            }else{
                
                //check correct answers
                for (int i = 0; i < listQuiz.size(); i++) {
                    
                    //get array answers 
                    String[] ans = request.getParameterValues("ans" + i);
                    String strAns = "";
                    
                    if (ans != null) {
                        //convert array answer to string answer
                        for (int j = 0; j < ans.length; j++) {
                            strAns += ans[j];
                        }
                    }

                    //compare result
                    if (strAns.equals(listQuiz.get(i).getAnswer())) {
                        countTrue++;
                    }

                }

                //Calculate score to display
                int rawScore = (countTrue * 100 / listQuiz.size());
                float score = (float) rawScore / 10;
                strScore = score + "";
                if (strScore.endsWith(".0")) {
                    strScore = strScore.substring(0, strScore.length() - 2);
                }

                //Calculate percent to display
                float percent = (float) rawScore;
                String strPercent = percent + "";
                if (strPercent.endsWith(".0")) {
                    strPercent = strPercent.substring(0, strPercent.length() - 2);
                }
                
                status = (score < 5) ? "Fail" : "Pass";

                request.setAttribute("status", status);
                request.setAttribute("strScore", strScore);
                request.setAttribute("strPercent", strPercent);
            }
            User instanceUser = (User) session.getAttribute("user");
            questionDAO.insertQuizHistory(instanceUser.getId(), strScore, status);
            request.setAttribute("message", message);
            request.getRequestDispatcher("resultQuiz.jsp").forward(request, response);
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
