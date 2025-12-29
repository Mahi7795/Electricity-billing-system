import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // UPDATE THE PASSWORD HERE!
            // If you set a password during MySQL installation, enter it
            // If you didn't set a password, use empty string ""

            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebs",
                    "root",
                    "Mahesh@123" // ← CHANGE THIS!
            );
            s = c.createStatement();
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.err.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
