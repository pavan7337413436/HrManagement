package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.DeleteClass;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	DeleteClass dc = new DeleteClass();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String empId = request.getParameter("id");
	String result = "";
	try {
		result = dc.deleteValues(empId);
	}catch(Exception e) {
		e.printStackTrace();
	}
	//response.getWriter().write(result);
	if(result.equalsIgnoreCase("success")) {
		request.getRequestDispatcher("ViewServlet").forward(request, response);
	}else {
		request.getRequestDispatcher("ViewServlet").forward(request, response);
	}
	}
}
