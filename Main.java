public class Main {
    public static void main(String[] args) {
        Admission admission = new Admission();

        // Add a student
        Student s1 = new Student(1, "Thanvika", "thanvika@gmail.com", 89.5f);
        admission.addStudent(s1);

        // Add a course
        Course c1 = new Course(101, "Computer Science", 85);
        admission.addCourse(c1);

        // Apply for course
        admission.applyForCourse(1001, 1, 101);

        // Process application
        admission.processApplication(1001);

        // View all applications
        for (Application app : admission.viewApplications()) {
            System.out.println(app);
        }

        // Close connection
        admission.closeConnection();
    }
}
