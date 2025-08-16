import java.util.*;

public class Admin extends User {
    private List<MCQ> questionBank;

    public Admin(String username, String password, List<MCQ> questionBank) {
        super(username, password);
        this.questionBank = questionBank;
    }

    @Override
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nAdmin Menu:\n1. Add Question\n2. View All Questions\n0. Logout");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addQuestion(sc);
                    break;
                case 2:
                    viewQuestions();
                    break;
                case 0:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (choice != 0);
    }

    private void addQuestion(Scanner sc) {
        System.out.print("Enter question: ");
        String qText = sc.nextLine();
        String[] options = new String[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Option " + (char)('A' + i) + ": ");
            options[i] = sc.nextLine();
        }
        System.out.print("Correct option (A/B/C/D): ");
        String correct = sc.nextLine().toUpperCase();
        questionBank.add(new MCQ(qText, options, correct));
        System.out.println("Question added successfully!");
    }

    private void viewQuestions() {
        for (MCQ q : questionBank) {
            q.display();
        }
    }
}
