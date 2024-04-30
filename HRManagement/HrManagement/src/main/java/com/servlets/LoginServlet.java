package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    LoginDao ld = new LoginDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String result = "";

        try {
            result = ld.getResult(userName, pwd);
       
        if (result.equals("admin")) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", userName);
            response.sendRedirect("Admin.jsp");
        } else if (result.equalsIgnoreCase("employee")) {
        	HttpSession session = request.getSession();
        	session.setAttribute("user", userName);
            response.sendRedirect("employeeDashboard.jsp");
        }
         else {
            request.getRequestDispatcher("login.html").include(request, response);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


