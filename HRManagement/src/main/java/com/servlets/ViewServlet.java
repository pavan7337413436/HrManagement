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

        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Employee List</title>");
        pw.println("<style>");
        pw.println("table {");
        pw.println("    width: 100%;");
        pw.println("    border-collapse: collapse;");
        pw.println("}");
        pw.println("th, td {");
        pw.println("    padding: 8px;");
        pw.println("    text-align: left;");
        pw.println("    border-bottom: 1px solid #ddd;");
        pw.println("}");
        pw.println("tr:hover {");
        pw.println("    background-color: #f5f5f5;");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");

        pw.println("<h2>Employee List</h2>");
        pw.println("<table>");
        pw.println("<tr>");
        pw.println("<th>Employee ID</th>");
        pw.println("<th>User Name</th>");
        pw.println("<th>Password</th>");
        pw.println("<th>Role</th>");
        pw.println("<th>Mobile Number</th>");
        pw.println("<th>Village</th>");
        pw.println("<th>Salary</th>");
        pw.println("<th>Update</th>");
        pw.println("<th>Delete</th>");
        pw.println("</tr>");

        for (Employee employee : emp) {
            pw.println("<tr>");
            pw.println("<td>" + employee.getEmployeeId() + "</td>");
            pw.println("<td>" + employee.getUserName() + "</td>");
            pw.println("<td>" + employee.getPassword() + "</td>");
            pw.println("<td>" + employee.getRole() + "</td>");
            pw.println("<td>" + employee.getMobileNumber() + "</td>");
            pw.println("<td>" + employee.getVillage() + "</td>");
            pw.println("<td>" + employee.getSalary() + "</td>");
            pw.println("<td><a href='update.html?emp_id=" + employee.getEmployeeId() + "'>Update</a></td>");
            pw.println("<td><a href='DeleteServlet?id=" + employee.getEmployeeId() + "'>Delete</a></td>");
            pw.println("</tr>");
        }

        pw.println("</table>");
        pw.println("<a href=\"login.html\">Logout</a>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
