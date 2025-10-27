public class Course {
    // Variables (fields)
    private int courseId;
    private String courseName;
    private float cutoff;

    // Empty constructor
    public Course() {
        // allows creating an empty Course object
    }

    // Constructor with parameters
    public Course(int courseId, String courseName, float cutoff) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.cutoff = cutoff;
    }

    // Getters and Setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public float getCutoff() {
        return cutoff;
    }

    public void setCutoff(float cutoff) {
        this.cutoff = cutoff;
    }

    // Display method
    @Override
    public String toString() {
        return "Course ID: " + courseId +
               ", Name: " + courseName +
               ", Cutoff: " + cutoff;
    }
}
