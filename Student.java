import java.util.*;

public class Student extends User {
    private List<MCQ> questionBank;

    public Student(String username, String password, List<MCQ> questionBank) {
        super(username, password);
        this.questionBank = questionBank;
    }

    @Override
    public void showMenu() {
        Quiz quiz = new Quiz(questionBank);
        quiz.start();
    }
}
