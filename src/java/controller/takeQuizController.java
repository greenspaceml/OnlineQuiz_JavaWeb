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
import processSupport.Supporter;

/**
 *
 * @author green
 */
public class takeQuizController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Supporter supporter = new Supporter();
            long endTime = 0;
            int quiz = (int) request.getAttribute("quiz");
            QuestionDAO questionDAO = new QuestionDAO();

            ArrayList<Question> listQuiz = questionDAO.getRandomQuestion(quiz);
            HttpSession session = request.getSession();
            session.setAttribute("listQuiz", listQuiz);

            long timePerQuiz = 2;
            long totalTime = listQuiz.size() * timePerQuiz;
            endTime = supporter.getEndingTime(totalTime);

            session.setAttribute("endTime", endTime);

            request.setAttribute("totalTime", totalTime);
            request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
