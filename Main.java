import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<MCQ> questionBank = new ArrayList<>();

        Map<String, User> users = new HashMap<>();
        users.put("admin", new Admin("admin", "admin123", questionBank));
        users.put("student", new Student("student", "stud123", questionBank));

        System.out.println("Welcome to Online Exam Portal");
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pwd = sc.nextLine();

        User user = users.get(uname);
        if (user != null && user.password.equals(pwd)) {
            user.showMenu();
        } else {
            System.out.println("Invalid credentials.");
        }
        sc.close();
    }
}
