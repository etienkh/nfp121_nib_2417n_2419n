/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

/**
 *
 * @author Georges
 */
public class Resultat {

    String matiereTitle;
    double note;
    String quizTitle;

    public Resultat(String codeMatiere, double note, String quizTitle) {
        this.matiereTitle = codeMatiere;
        this.note = note;
        this.quizTitle = quizTitle;
    }
}
