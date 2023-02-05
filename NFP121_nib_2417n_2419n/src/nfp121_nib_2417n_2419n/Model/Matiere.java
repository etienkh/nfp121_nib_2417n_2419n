/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import nfp121_nib_2417n_2419n.MVC.MyObservable;

/**
 *
 * @author Georges
 */
public class Matiere extends MyObservable implements Serializable{

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

    //private ArrayList<String> videos;

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
        //   this.videos = new ArrayList<String>();
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public int getPrice() {
        return price;
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

//    ArrayList<String> getVideos() {
//        return videos;
//    }
}
