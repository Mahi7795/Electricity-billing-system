import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try {
            System.out.println("Testing MySQL Connection...");

            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");

            // Try to connect (use same credentials as in Conn.java)
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebs",
                    "root",
                    "Mahesh@123" // ← Use the same password you put in Conn.java
            );

            System.out.println("SUCCESS! Connected to MySQL database!");

            // Test if tables exist
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW TABLES");
            System.out.println("\nTables in ebs database:");
            while (rs.next()) {
                System.out.println("- " + rs.getString(1));
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("FAILED to connect!");
            System.err.println("Error: " + e.getMessage());
        }
    }
}