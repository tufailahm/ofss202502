package com.training.finance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBCConnection {
    public static void main(String[] args) {
        // Replace with your Oracle DB credentials
        String jdbcUrl = "jdbc:oracle:thin:@10.120.93.4:1521:free";  // xe is default SID for Oracle Express
        String username = "system";
        String password = "root";

        try {
            // Load Oracle JDBC Driver (optional for Java 6+)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Get connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Confirm connection
            if (connection != null) {
                System.out.println("Connected to Oracle database successfully!");
                connection.close();
            } else {
                System.out.println("Failed to connect to Oracle database.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}
