package com.classes;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.Employee;
public class SearchClass {


	public List<Employee> search(String uId) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> userList = new ArrayList<Employee>();
		try {
			String url = "jdbc:mysql://localhost:3306/spdcl";
			String username = "root";
			String password = "root";

			String query = "select  employee_id, username, password, role, mobile_num, village, salary from user where employee_id=?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, uId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getString(1));
				emp.setUserName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setRole(rs.getString(4));
				emp.setMobileNumber(rs.getString(5));
				emp.setVillage(rs.getString(6));
				emp.setSalary(rs.getString(7));


				userList.add(emp);


			}
		}
		catch(Exception e) {             
			e.printStackTrace();
		} finally {
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

		return userList;
	}
}