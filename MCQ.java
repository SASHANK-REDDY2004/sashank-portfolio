public class MCQ extends Question {
    private String[] options;
    private String correctAnswer;

    public MCQ(String questionText, String[] options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char)('A' + i) + ". " + options[i]);
        }
    }

    @Override
    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}
