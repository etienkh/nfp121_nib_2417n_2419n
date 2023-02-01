package nfp121_nib_2417n_2419n.Model;

import java.util.List;

public class Question {

    private String question;
    private List<String> choices;
    private String correctChoice;

    public Question(String question, List<String> options, String answer) {
        this.question = question;
        this.choices = options;
        this.correctChoice = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return choices;
    }

    public void setOptions(List<String> options) {
        this.choices = options;
    }

    public String getAnswer() {
        return correctChoice;
    }

    public void setAnswer(String answer) {
        this.correctChoice = answer;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getCorrectChoice() {
        return correctChoice;
    }

    public boolean isCorrect(String choice) {
        return correctChoice.equals(choice);
    }
}
