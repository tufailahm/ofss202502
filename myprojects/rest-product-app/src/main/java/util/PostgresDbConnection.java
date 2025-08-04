package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDbConnection {
    public static Connection  getPostgresConnection() {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";  // xe is default SID for Oracle Express
        String username = "postgres";
        String password = "root";
        Connection con;
        try {
            // Load Oracle JDBC Driver (optional for Java 6+)
            Class.forName("org.postgresql.Driver");
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
    public static void main(String[] args) {
        Connection con = getPostgresConnection();
        System.out.println("Connected to Postgres");
    }
}