package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classes.ViewClass; // Assuming ViewClass contains the logic to retrieve data

import modal.Employee;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ViewClass vc = new ViewClass(); 
        List<Employee> emp = null;
		try {
			emp = vc.view();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        String htmlResponse = "<html><table border=1><tr><th>EmployeeId</th><th>User Name</th><th>Password</th><th>Role</th><th>Mobile Number</th><th>Village</th><th>salary</th><th>Update</th><th>Delete</th></tr>";

        for (Employee employee : emp) {
			htmlResponse += "<tr><td>"+employee.getEmployeeId()+"</td><td>"+employee.getUserName()+"</td><td>"+employee.getPassword()+"</td><td>"+employee.getRole()+"</td><td>"+employee.getMobileNumber()+"</td><td>"+employee.getVillage()+"</td><td>"+employee.getSalary()+"</td>";
			htmlResponse += "<td><a href='update.html?emp_id=" + employee.getEmployeeId() + "&username=" + employee.getUserName() + "&pwd=" + employee.getPassword() + "&role=" + employee.getRole() + "&mobile=" + employee.getMobileNumber() + "&village=" + employee.getVillage() + "&salary=" + employee.getSalary() + "'>Update</td>";
			htmlResponse+= "<td><a href = 'DeleteServlet?id=" +employee.getEmployeeId()+"'>Delete</td></tr>";

        }
        htmlResponse += "</table></html>";

        pw.println(htmlResponse);
        pw.println("<a href=\"login.html\">Logout</a>");
    }
}
