import java.io.FileNotFoundException;

public interface CourseService {
    abstract int addNewCourse(int id , String title, String Start , String End,boolean avalable);


    abstract int getAllCourses(boolean avalable);

    abstract void getCourseById(int id );
}
