/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author green
 */
public class jspFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest fRequest = (HttpServletRequest) request;
            HttpServletResponse fResponse = (HttpServletResponse) response;
            //get the URI of the current site
            String URI = fRequest.getRequestURI();
            URI = URI.substring(fRequest.getContextPath().length() + 1, URI.length());
            //123takeQuiz.jsp
//            System.out.println(URI + "---------------------------------------------");
            if (URI.endsWith(".jsp")) {
                if (URI.equals("information.jsp")) {
                    fResponse.sendRedirect("home");
                } else if (URI.equals("login.jsp")) {
                    fResponse.sendRedirect("login");
                } else if (URI.equals("makeQuiz.jsp")) {
                    fResponse.sendRedirect("makeQuiz");
                } else if (URI.equals("manageQuiz.jsp")) {
                    fResponse.sendRedirect("manageQuiz");
                } else if (URI.equals("prepareQuiz.jsp") || URI.equals("takeQuiz.jsp") || URI.equals("resultQuiz.jsp")) {
                    fResponse.sendRedirect("prepareQuiz");
                } else if (URI.equals("register.jsp")) {
                    fResponse.sendRedirect("register");
                } else {
                    fResponse.sendRedirect("home");
                }
            } else {
                chain.doFilter(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
