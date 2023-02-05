package nfp121_nib_2417n_2419n.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import nfp121_nib_2417n_2419n.MVC.MyObservable;

public class Quiz extends MyObservable implements Serializable {

    private String quizTitle;
    private List<Question> questions;
    private double maxGrade;
    public double getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(double maxGrade) {
        this.maxGrade = maxGrade;
    }

    private double questionGrade;

    public double getQuestionGrade() {
        return questionGrade;
    }

    public void setQuestionGrade(double questionGrade) {
        this.questionGrade = questionGrade;
    }

    public Quiz(String quizTitle, List<Question> questions) {
        this.quizTitle = quizTitle;
        this.questions = questions;
    }

    public Quiz() {
        questions = new ArrayList<>();
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
        setChanged();
        notifyObservers();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        setChanged();
        notifyObservers();
    }

    public void clear() {
        quizTitle = "";
        questions.clear();
        setChanged();
        notifyObservers();
    }

    public String toString() {
        String s = "Title : " + quizTitle + "\n\n";
        int index = 1;
        for (Question el : questions) {
            s += "Question " + index + ": " + el.getQuestion() + "\nChoices :\n" + String.join("\n", el.getChoices())
                    + "\nCorrect choice:" + el.getCorrectChoice();
            s += "\n\n";
            index++;
        }
        ;
        return s;
    }

    public boolean isValid() {
        if (quizTitle.isEmpty() || questions.size() == 0) {
            return false;
        } else {
            for (Question question : questions) {
                if (!question.isValid()) {
                    return false;
                }
            }
            return true;
        }
    }
}
