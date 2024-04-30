package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public String getResult(String userName, String password) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/spdcl";
        String user = "root";
        String pwd = "root";
        String query = "select username, password, role from user where username=? and password=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pwd);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("role");
            } else {
                return "fail";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}