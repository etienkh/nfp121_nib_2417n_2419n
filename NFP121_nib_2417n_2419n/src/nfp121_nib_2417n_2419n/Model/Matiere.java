/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Georges
 */
public class Matiere implements Serializable {

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

    public Matiere(String code, String name, int credit, ArrayList<String> sessions, ArrayList<String> syllabus, ArrayList<String> objectifs, ArrayList<String> chapitres, ArrayList<String> documents, ArrayList<String> videos) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.price = 12;
        this.sessions = sessions;
        this.syllabus = syllabus;
        this.objectifs = objectifs;
        this.chapitres = chapitres;
        this.documents = documents;
        this.videos = videos;
    }

    ArrayList<String> getSessions() {
        return sessions;
    }

    ArrayList<String> getSyllabus() {
        return syllabus;
    }

    ArrayList<String> getObjectifs() {
        return objectifs;
    }

    ArrayList<String> getChapitres() {
        return chapitres;
    }

    ArrayList<String> getDocuments() {
        return documents;
    }

    ArrayList<String> getVideos() {
        return videos;
    }
}
