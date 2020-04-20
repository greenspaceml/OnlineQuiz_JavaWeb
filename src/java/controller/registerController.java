/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author green
 */
public class registerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("register.jsp").forward(request, response);
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
            String message = "";
            boolean checkCreated = false;
            int userType = 0;
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String type = request.getParameter("type");
            String email = request.getParameter("email");

            //check if any of input is blank or not
            if (username.trim().equals("") || password.trim().equals("") || email.trim().equals("")) {
                message = "Please fill all of the requested information";
            }
            userType = (type.equals("false") ? 0 : 1);
            //check mail format
            boolean isEmail = email.matches("^(.+)@(.+)$");
            
            if (message.equals("") && !isEmail) {
                message = "Incorrect email format";
            }

            UserDAO userDAO = new UserDAO();
            //check user
            User u = userDAO.getUserByUsername(username);
            //User does not exist and email correct
            if (u.getUsername() == null && message.equals("") && isEmail) {
                checkCreated =  userDAO.createNewUser(username, password, email, userType);
                if (checkCreated) {
                    message = "Sign Up Success";
                }else{
                    message = "Create failed";
                }
            } else if (u.getUsername() != null) {
                message = "Username existed";
            }

            request.setAttribute("message", message);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.setAttribute("type", type);

            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
