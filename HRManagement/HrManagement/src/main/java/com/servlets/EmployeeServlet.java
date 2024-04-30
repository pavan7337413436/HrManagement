package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classes.EmployeeClass;

import modal.Employee;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeClass ec = new EmployeeClass();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     HttpSession session = request.getSession();
     String userName = (String)session.getAttribute("user");
     System.out.println("hi"+userName);
     
			 if(userName !=null) {
			 try {
					List<Employee> emp =ec.getResult(userName);
				    PrintWriter pw=response.getWriter();
				    String htmlResponse="<html><table border='1'><tr><th>User Id</th><th>User Name</th><th>Password</th><th>Role</th><th>Mobile Number</th><th>User Village</th><th>User Salary</th></tr>";
				    for(Employee users :emp) {
				    	System.out.println(users.toString());
				    	htmlResponse+="<tr><td>"+users.getEmployeeId()+"</td><td>"+users.getUserName()+"</td><td>"+users.getPassword()+"</td><td>"+users.getRole()+"</td><td>"+users.getMobileNumber()+"</td><td>"+users.getVillage()+"</td><td>"+users.getSalary()+"</td></tr>";
				    	//htmlResponse+="<td><a>update</a></td>";
				System.out.println(htmlResponse);    			
				    }
				    htmlResponse+="</table></html>";
				    pw.println(htmlResponse);
					} catch (Exception e) {
						e.printStackTrace();
					}
			}

		}
}