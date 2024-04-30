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

        if(userName != null) {
            try {
                List<Employee> emp = ec.getResult(userName);
                generateHtmlResponse(emp, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving employee data.");
            }
        } else {
            response.sendRedirect("login.html");
        }
    }

    private void generateHtmlResponse(List<Employee> emp, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Employee List</title>");
        pw.println("<style>");
        pw.println("table {");
        pw.println("    border-collapse: collapse;");
        pw.println("    width: 100%;");
        pw.println("}");
        pw.println("th, td {");
        pw.println("    border: 1px solid black;");
        pw.println("    padding: 8px;");
        pw.println("    text-align: left;");
        pw.println("}");
        pw.println("th {");
        pw.println("    background-color: #f2f2f2;");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<h1>Employee List</h1>");
        pw.println("<table>");
        pw.println("<tr><th>User Id</th><th>User Name</th><th>Password</th><th>Role</th><th>Mobile Number</th><th>User Village</th><th>User Salary</th></tr>");

        for (Employee user : emp) {
            pw.println("<tr>");
            pw.println("<td>" + user.getEmployeeId() + "</td>");
            pw.println("<td>" + user.getUserName() + "</td>");
            pw.println("<td>" + user.getPassword() + "</td>");
            pw.println("<td>" + user.getRole() + "</td>");
            pw.println("<td>" + user.getMobileNumber() + "</td>");
            pw.println("<td>" + user.getVillage() + "</td>");
            pw.println("<td>" + user.getSalary() + "</td>");
            pw.println("</tr>");
        }

        pw.println("</table>");
        pw.println("</body>");
        pw.println("</html>");
    }
}
