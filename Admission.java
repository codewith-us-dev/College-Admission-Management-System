import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Admission {
    private Connection con;

    // Constructor: automatically connects to database
    public Admission() {
        this.con = Database.getConnection();
    }

    public void addStudent(Student s) {
        String sql = "INSERT INTO student(student_id, student_name, email, marks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getEmail());
            ps.setFloat(4, s.getMarks());
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Student added successfully!");
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry"))
                System.out.println("⚠️ Student already exists with ID: " + s.getStudentId());
            else
                System.out.println("❌ Error adding student: " + e.getMessage());
        }
    }

    public List<Student> viewStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("email"),
                    rs.getFloat("marks")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching students: " + e.getMessage());
        }
        return list;
    }

    public void addCourse(Course c) {
        String sql = "INSERT INTO courses(course_id, course_name, cutoff) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getCourseId());
            ps.setString(2, c.getCourseName());
            ps.setFloat(3, c.getCutoff());
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Course added successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error adding course: " + e.getMessage());
        }
    }

    public void applyForCourse(int appId, int studentId, int courseId) {
        String sql = "INSERT INTO applications(app_id, student_id, course_id, app_status) VALUES (?, ?, ?, 'Pending')";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, appId);
            ps.setInt(2, studentId);
            ps.setInt(3, courseId);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Application submitted successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error applying for course: " + e.getMessage());
        }
    }

    public List<Application> viewApplications() {
        List<Application> list = new ArrayList<>();
        String sql = "SELECT * FROM applications";
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Application(
                    rs.getInt("app_id"),
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getString("app_status")
                ));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error fetching applications: " + e.getMessage());
        }
        return list;
    }

    public void processApplication(int appId) {
        String sql = "UPDATE applications a " +
                     "JOIN student s ON a.student_id = s.student_id " +
                     "JOIN courses c ON a.course_id = c.course_id " +
                     "SET a.app_status = CASE " +
                     "WHEN s.marks >= c.cutoff THEN 'Approved' " +
                     "ELSE 'Rejected' END " +
                     "WHERE a.app_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, appId);
            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("✅ Application processed successfully!");
            else
                System.out.println("⚠️ No application found with ID: " + appId);
        } catch (SQLException e) {
            System.out.println("❌ Error processing application: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("✅ Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error closing connection: " + e.getMessage());
        }
    }
}
