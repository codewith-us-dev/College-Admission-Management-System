import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/admissionmanagement";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Tiger";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // ✅ Load driver
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(" Connected to database!");
        } catch (Exception e) {
            System.out.println(" Database connection failed: " + e.getMessage());
        }
        return con;
    }
}
