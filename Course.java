import java.time.LocalDate;
import java.util.Random;


public class Course {
    private int courseId;
    private String courseTitle;
    private String courseStartedDate;
    private String courseEndedDate;
    private boolean isAvailable  ;

    public Course(int courseId, String courseTitle, String courseStartedDate, String courseEndedDate, boolean isAvailable) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseStartedDate = courseStartedDate;
        this.courseEndedDate = courseEndedDate;
        this.isAvailable = isAvailable;
    }
    public Course() {
        Random random = new Random();
        courseId = 0 + random.nextInt(99);
        courseStartedDate = String.valueOf(LocalDate.of(2024, 4, 22));
        courseEndedDate = String.valueOf(LocalDate.of(2024, 9, 29));
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseStartedDat() {
        return courseStartedDate;
    }

    public void setCourseStartedDat(String courseStartedDat) {
        this.courseStartedDate = courseStartedDat;
    }

    public String getCourseEndedDate() {
        return courseEndedDate;
    }

    public void setCourseEndedDate(String courseEndedDate) {
        this.courseEndedDate = courseEndedDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}


