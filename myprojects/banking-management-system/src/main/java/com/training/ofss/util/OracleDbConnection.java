package com.training.ofss.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDbConnection {
    public static Connection  getOracleConnection() {
        String jdbcUrl = "jdbc:oracle:thin:@10.120.93.4:1521:free";  // xe is default SID for Oracle Express
        String username = "system";
        String password = "root";
        Connection con;
        try {
            // Load Oracle JDBC Driver (optional for Java 6+)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                con = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    }
