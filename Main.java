

import javax.swing.table.TableCellEditor;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] agrs ){
            CourseServiceImp coursesevice = new CourseServiceImp();
            Course course = new Course();
            do {
            Scanner scanner = new Scanner(System.in);
            View.Menu();
            System.out.printf("Enter your choice [1-4] : ");
            int choice = scanner.nextInt();

                    switch (choice) {
                            case 1 -> {

                                    coursesevice.addNewCourse(course.getCourseId(), course.getCourseTitle(), course.getCourseStartedDat(), course.getCourseEndedDate(),course.isAvailable());
                            }
                            case 2 -> {
                                    coursesevice.getAllCourses(course.isAvailable());
                            }
                            case 3->{
                                    coursesevice.getCourseById(course.getCourseId());

                            }
                            case 4->
                            {
                                    System.out.printf("....Thanks You!!....");
                                    System.exit(0);
                            }


                    }
            }while(true);

    }
}
