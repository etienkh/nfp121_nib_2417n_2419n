    /*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
    * and open the template in the editor.
    */
    package nfp121_nib_2417n_2419n.Model;

import java.io.Serializable;

/**
     *
     * @author Georges
     */
    public class Resultat implements Serializable{

        private String matiereTitle;
        public String getMatiereTitle() {
            return matiereTitle;
        }

        public void setMatiereTitle(String matiereTitle) {
            this.matiereTitle = matiereTitle;
        }

        private double note;
        private double maxNote;
        public double getMaxNote() {
            return maxNote;
        }

        public void setMaxNote(double maxNote) {
            this.maxNote = maxNote;
        }

        public double getNote() {
            return note;
        }

        public void setNote(double note) {
            this.note = note;
        }

        private String quizTitle;

        public String getQuizTitle() {
            return quizTitle;
        }

        public void setQuizTitle(String quizTitle) {
            this.quizTitle = quizTitle;
        }

        public Resultat(String codeMatiere, double note, String quizTitle, double maxNote) {
            this.matiereTitle = codeMatiere;
            this.note = note;
            this.quizTitle = quizTitle;
            this.maxNote = maxNote;
        }
    }
