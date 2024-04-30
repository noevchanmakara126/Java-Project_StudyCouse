import java.util.Scanner;

public class View {
    public static void Menu(){
        System.out.println("==========Course----Menu==========");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Add new course");
        System.out.println("2. Get all courses");
        System.out.println("3. Search course by ID");
        System.out.println("4. Exit");
    }
}
