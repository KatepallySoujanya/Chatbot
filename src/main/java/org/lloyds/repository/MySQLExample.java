package org.lloyds.repository;


import java.sql.*;

public class MySQLExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            String url = "jdbc:mysql://34.66.54.207:3306/employee?useSSL=false";
            String DB_URL = "jdbc:mysql://google/employeedb?cloudSqlInstance=lloyds-hack-grp-12:us-central1:employee&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false";
            String username = "root";
            String password = "SomaSrilekha";
            conn = DriverManager.getConnection(url, username, password);

            // Do something with the connection (query, insert, etc.)
            // Example:
            // PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employeedetails");
            // ResultSet rs = pstmt.executeQuery();
            // Process the ResultSet if needed
            String query = "SELECT * FROM employeedetails WHERE employee_name = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "Soma");
            ResultSet rs = pstmt.executeQuery();

            // Process the ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String employeeName = rs.getString("employee_name");
                String dateOfJoining = rs.getString("date_of_joining");
                String managerName = rs.getString("manager_name");
                String labName = rs.getString("lab_name");
                String platformName = rs.getString("platform_name");

                System.out.println("Employee ID: " + id);
                System.out.println("Employee Name: " + employeeName);
                System.out.println("Date of Joining: " + dateOfJoining);
                System.out.println("Manager Name: " + managerName);
                System.out.println("Lab Name: " + labName);
                System.out.println("Platform Name: " + platformName);
                System.out.println();
            }

            // Close ResultSet, PreparedStatement, and Connection
            rs.close();
            pstmt.close();
            conn.close();
            // Close the connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

