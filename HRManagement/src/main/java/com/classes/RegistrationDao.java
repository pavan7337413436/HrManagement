package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDao {

    public String insertInto(String empId, String userName, String password, String role, String mobile, String village, String salary) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int i = 0;
        String url = "jdbc:mysql://localhost:3306/spdcl";
        String user = "root";
        String pwd = "root";
        String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?,?)";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            pstmt.setString(2, userName);
            pstmt.setString(3, password);
            pstmt.setString(4, role);
            pstmt.setString(5, mobile);
            pstmt.setString(6, village);
            pstmt.setString(7, salary);
            i = pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (i > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
}
