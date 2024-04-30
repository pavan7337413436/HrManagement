package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.Employee;




public class ViewClass {
	public List<Employee> view() throws ClassNotFoundException, SQLException  {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Employee> Employee = new ArrayList<Employee>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spdcl", "root", "root");
			pstmt = con.prepareStatement("select * from user where role=?");
			pstmt.setString(1, "employee");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp=new Employee();
				emp.setEmployeeId(rs.getString(1));
				emp.setUserName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setRole(rs.getString(4));
				emp.setMobileNumber(rs.getString(5));
				emp.setVillage(rs.getString(6));
				emp.setSalary(rs.getString(7));
				Employee.add(emp);

			} 

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				con.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		return Employee;

	}

}
