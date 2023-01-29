package nfp121_nib_2417n_2419n.Model;

import java.util.List;

public class Quiz {

    private String quizTitle;
    private List<Question> questions;

    public Quiz(String quizTitle, List<Question> questions) {
        this.quizTitle = quizTitle;
        this.questions = questions;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

}
