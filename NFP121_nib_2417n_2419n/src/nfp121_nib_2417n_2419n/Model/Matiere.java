/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

import java.util.ArrayList;
import nfp121_nib_2417n_2419n.MVC.MyObservable;

/**
 *
 * @author Georges
 */
public class Matiere extends MyObservable {

    private String code;
    private String name;
    private int credit;
    private int price;
    private ArrayList<String> sessions;
    private ArrayList<String> syllabus;
    private ArrayList<String> objectifs;
    private ArrayList<String> chapitres;
    private ArrayList<String> documents;
    private ArrayList<String> videos;
    private ArrayList<Quiz> quizzes;

    public String getCode() {
        return code;
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

    Matiere() {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.price = 12;
        this.sessions = new ArrayList<String>();
        this.syllabus = new ArrayList<String>();
        this.objectifs = new ArrayList<String>();
        this.chapitres = new ArrayList<String>();
        this.documents = new ArrayList<String>();
        this.videos = new ArrayList<String>();
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

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public ArrayList<String> getVideos() {
        return videos;
    }
}
