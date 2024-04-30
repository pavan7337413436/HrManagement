package com.classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class UpdateClass {
public String updateValues(String empId, String userName, String password, String role, String mobile, String village,String salary) {
       int i = 0;
	
	try {
    	  
		String url = "jdbc:mysql://localhost:3306/spdcl";
		String user = "root";
		String pwd = "root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pwd);
		String query = "update user set username=?, password=?, role=?, mobile_num=?, village=?, salary=? where employee_id=?";
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, userName);
		pstmt.setString(2, password);
		pstmt.setString(3, role);
		pstmt.setString(4, mobile);
		pstmt.setString(5, village);
		pstmt.setString(6,salary);
		pstmt.setString(7, empId);
		i = pstmt.executeUpdate(); 
	} catch(Exception e) {
		e.printStackTrace();
	} if(i > 0) {
		return "success";
	}else {
		return "fail";
	}
}
}
