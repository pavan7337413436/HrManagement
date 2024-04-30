package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.UpdateClass;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UpdateClass uc = new UpdateClass();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("emp_id");
		String userName = request.getParameter("username");
		String password = request.getParameter("pwd");
		String role = request.getParameter("role");
		String mobile = request.getParameter("mobile");
		String village = request.getParameter("village");
		String salary = request.getParameter("salary");

		String result = "";
		
		try {
			result = uc.updateValues(empId, userName, password, role, mobile, village,salary);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result == "success") {
			request.getRequestDispatcher("ViewServlet").forward(request, response);
		} else {
			request.getRequestDispatcher("update.html").include(request, response);
		}

		
	}

}
