package nfp121_nib_2417n_2419n.Model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.TemplateMethod.QuizTemplate;

/**
 *
 * @author Georges
 */
public class Matiere extends MyObservable implements Serializable {

    private String code;
    private String name;
    private int credit;
    private int price;
    private ArrayList<String> sessions;
    private ArrayList<String> syllabus;
    private ArrayList<String> objectifs;
    private ArrayList<String> chapitres;
    private ArrayList<File> documents;
    private ArrayList<String> videos;
    private ArrayList<Quiz> quizzes;
    private QuizTemplate quizTemplate;

    public QuizTemplate getQuizTemplate() {
        return quizTemplate;
    }

    public void setQuizTemplate(QuizTemplate quizTemplate) {
        this.quizTemplate = quizTemplate;
    }

    public String getCode() {
        return code;
    }

    public List<MyObserver> getObservers (){
        return super.observers;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
        setChanged();
        notifyObservers();
    }

    // private ArrayList<String> videos;

    public Matiere(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.price = 12 * credit;
        this.sessions = new ArrayList<String>();
        this.syllabus = new ArrayList<String>();
        this.objectifs = new ArrayList<String>();
        this.chapitres = new ArrayList<String>();
        this.documents = new ArrayList<File>();
        this.quizzes = new ArrayList<Quiz>();
        // this.videos = new ArrayList<String>();
    }

    public Matiere(){
        this.sessions = new ArrayList<String>();
        this.syllabus = new ArrayList<String>();
        this.objectifs = new ArrayList<String>();
        this.chapitres = new ArrayList<String>();
        this.documents = new ArrayList<File>();
        this.quizzes = new ArrayList<Quiz>();
    }

    public ArrayList<String> getSessions() {
        return sessions;
    }

    public ArrayList<String> getSyllabus() {
        return syllabus;
    }

    public ArrayList<String> getObjectifs() {
        return objectifs;
    }

    public ArrayList<String> getChapitres() {
        return chapitres;
    }

    public ArrayList<File> getDocuments() {
        return documents;
    }

    public String toString() {
        return code + ":" + name + " credit " + credit + " price " + price;
    }

    // ArrayList<String> getVideos() {
    // return videos;
    // }
}
