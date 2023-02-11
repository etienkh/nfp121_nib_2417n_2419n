/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

import java.util.Observable;

/**
 *
 * @author Georges
 */
public class Resultat extends Observable{

    public String getMatiereTitle() {
        return matiereTitle;
    }

    public double getNote() {
        return note;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    private String matiereTitle;
    private double note;
    private String quizTitle;

    public Resultat(String codeMatiere, double note, String quizTitle) {
        this.matiereTitle = codeMatiere;
        this.note = note;
        this.quizTitle = quizTitle;
    }
}
