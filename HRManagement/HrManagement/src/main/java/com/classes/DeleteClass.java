package com.classes;
import java.sql.*;
public class DeleteClass {
public String deleteValues(String empId) throws Exception{
	Connection con = null;
	PreparedStatement pstmt = null;
	int i = 0;
	
	try {
		String url = "jdbc:mysql://localhost:3306/spdcl";
		String user = "root";
		String pwd = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pwd);
		pstmt = con.prepareStatement("delete  from user where employee_id=?");
		pstmt.setString(1, empId);
		i = pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}if(i > 0){
		return "success";
	} else {
		return "fail";
	}
}
}
