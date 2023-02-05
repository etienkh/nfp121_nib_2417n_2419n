package nfp121_nib_2417n_2419n.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nfp121_nib_2417n_2419n.MVC.MyObservable;

public class Question extends MyObservable implements Serializable {

    private String question;
    private List<String> choices;
    private String correctChoice;

    public Question(String question, List<String> options, String answer) {
        this.question = question;
        this.choices = options;
        this.correctChoice = answer;
    }

    public Question() {
        this.question = "";
        this.choices = new ArrayList<String>();
        this.correctChoice = "";
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
        setChanged();
        notifyObservers();
    }

    public List<String> getOptions() {
        return choices;
    }

    public void setOptions(List<String> options) {
        this.choices = options;
        setChanged();
        notifyObservers();
    }

    public String getAnswer() {
        return correctChoice;
    }

    public void setAnswer(String answer) {
        this.correctChoice = answer;
        setChanged();
        notifyObservers();
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
    
    public boolean isValid (){
        if(question.isEmpty() || choices.size() == 0 || correctChoice.isEmpty()){
            return false;
        }else{
            return true;    
        }
    }
}
