package nfp121_nib_2417n_2419n.Model;

import java.io.Serializable;

public class Answers implements Serializable{
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Answers(Question question, String answer) {
        this.question = question;
        this.answer = answer;
    }

}
