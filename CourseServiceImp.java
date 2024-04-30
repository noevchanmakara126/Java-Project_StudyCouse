import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseServiceImp implements CourseService {
    String CSV_FILE_PATH = "course.csv";

    @Override
    public int addNewCourse(int id, String title, String Start, String End, boolean avalable) {

        try {
            FileOutputStream output = new FileOutputStream(CSV_FILE_PATH, true);
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Please Enter Course Title : ");
            String ctitle = scanner.nextLine();
            String Content = id + "," + ctitle + "," + Start + "," + End + ", \n";
            output.write(Content.getBytes(StandardCharsets.UTF_8));
            System.out.printf("Success!!");
            output.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return 0;
    }

    @Override
    public int getAllCourses(boolean available) {
        List<Course> courses = new ArrayList<>();
        String line;
        String[] data;

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            while ((line = reader.readLine()) != null) {
                data = line.split(",");
                if (data.length >= 5) {
                    boolean courseAvailable = Boolean.parseBoolean(data[4]);

                    if (courseAvailable == available) {
                        int id = Integer.parseInt(data[0]);
                        String title = data[1];
                        String start = data[2];
                        String end = data[3];
                        courses.add(new Course(id, title, start, end, true));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Table table = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.addCell(" Course ID");
        table.addCell(" Course Title");
        table.addCell(" Course Start Date");
        table.addCell(" Course End Date ");
        table.addCell("Available");
        for (Course course : courses) {
            table.addCell(String.valueOf(course.getCourseId()));
            table.addCell(course.getCourseTitle());
            table.addCell(course.getCourseStartedDat());
            table.addCell(course.getCourseEndedDate());
            table.addCell(String.valueOf(course.isAvailable()));


        }


        System.out.println(table.render());


        return courses.size();
}
    @Override
    public void getCourseById(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course ID to search: ");
        int searchId = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            Table table = new Table(5,BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
            table.addCell(" Course ID");
            table.addCell(" Course Title");
            table.addCell("Course Start Date");
            table.addCell("Course End Date");
            table.addCell("Available");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    int courseId = Integer.parseInt(data[0]);
                    if (courseId == searchId) {
                        String title = data[1];
                        String start = data[2];
                        String end = data[3];
                        boolean available = Boolean.parseBoolean(data[4]);
                        System.out.println("Course found:");
                        table.addCell(String.valueOf(courseId));
                        table.addCell(title);
                        table.addCell(start);
                        table.addCell(end);
                        table.addCell(String.valueOf(true));

                        found = true;
                        break;
                    }
                }
            }System.out.println(table.render());
            if (!found) {
                System.out.println("Course with ID " + searchId + " not found.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}

