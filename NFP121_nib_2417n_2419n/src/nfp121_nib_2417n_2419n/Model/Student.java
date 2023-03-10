package nfp121_nib_2417n_2419n.Model;

import java.util.ArrayList;

public class Student extends Person {

    private ArrayList<Matiere> matiereIns;
    public void setMatiereIns(ArrayList<Matiere> matiereIns) {
        this.matiereIns = matiereIns;
    }
    private Boolean payement;
    private ArrayList<Resultat> resultats;

    public ArrayList<Matiere> getMatieres() {
        return matiereIns;
    }

    public ArrayList<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(ArrayList<Resultat> resultats) {
        this.resultats = resultats;
    }

    public Student(String username, String firstName, String lastName, String password) {
        super(username, firstName, lastName, password);
        this.matiereIns = new ArrayList<Matiere>();
        this.resultats = new ArrayList<Resultat>();
    }

    public ArrayList<Matiere> getMatiereIns() {
        return matiereIns;
    }

    public void addMatiereIns(Matiere matiere) {
        matiereIns.add(matiere);
        setChanged();
        notifyObservers();
    }
    public boolean getPayement(){
        if(payement != null){
        return payement;
        }
        return false;
    }

    public void setPayement(Boolean payement) {
        this.payement = payement;
        setChanged();
        notifyObservers();
    }
    public String toString(){
        return username+" "+firstName+" "+lastName;
    }

}
