
public class Application {
    // Variables (fields)
    private int appId;
    private int studentId;
    private int courseId;
    private String appStatus;
    
    public Application() {
        
    }

    public Application(int appId, int studentId, int courseId, String appStatus) {
        this.appId = appId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.appStatus = appStatus;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    
    @Override
    public String toString() {
        return "Application ID: " + appId +
               ", Student ID: " + studentId +
               ", Course ID: " + courseId +
               ", Status: " + appStatus;
    }
}
