package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.RegistrationDao;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    RegistrationDao rd = new RegistrationDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("emp_id");
		String userName = request.getParameter("username");
		String password = request.getParameter("pwd");
		String role = request.getParameter("role");
		String mobile = request.getParameter("mobile");
		String village = request.getParameter("village");
		String salary = request.getParameter("salary");
		String result = "";
		try {
			result = rd.insertInto(empId, userName, password, role, mobile, village, salary);
		}catch(Exception e) {
			e.printStackTrace();
		}
		//response.getWriter().write(result);
		if(result.equalsIgnoreCase("success")) {
			response.getWriter().write("your registration is success");
			request.getRequestDispatcher("login.html").forward(request, response);
		}else {
			response.getWriter().write("please valid registration details");
			request.getRequestDispatcher("registration.html").include(request, response);
		}
	}

}
