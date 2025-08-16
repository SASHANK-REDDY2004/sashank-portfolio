import java.util.*;

public class Quiz {
    private List<MCQ> questions;
    private int score = 0;

    public Quiz(List<MCQ> questions) {
        this.questions = questions;
    }

    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            for (MCQ q : questions) {
                q.display();
                System.out.print("Your answer: ");
                String ans = sc.nextLine().toUpperCase();
                if (q.evaluate(ans)) score++;
            }
            System.out.println("Quiz completed! Score: " + score + "/" + questions.size());
        }
    }
}
