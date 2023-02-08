package nfp121_nib_2417n_2419n.Model;

import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Matiere> matiereIns;
    private ArrayList<Resultat> resultats;

    public ArrayList<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(ArrayList<Resultat> resultats) {
        this.resultats = resultats;
    }

   public Student(String username, String firstName, String lastName, String password) {
        super(username, firstName, lastName, password);
        this.matiereIns = new ArrayList<Matiere>();

    }

    public ArrayList<Matiere> getMatiereIns() {
        return matiereIns;
    }

}
