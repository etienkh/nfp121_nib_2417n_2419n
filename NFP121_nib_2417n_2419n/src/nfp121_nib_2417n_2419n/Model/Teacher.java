package nfp121_nib_2417n_2419n.Model;

import java.util.ArrayList;

public class Teacher extends Person {

    private Matiere matiereT;
    private ArrayList<Session> sessions;

    public Teacher(String username, String firstName, String lastName, String password, Matiere matiereT) {
        super(username, firstName, lastName, password);
        this.matiereT = matiereT;
        sessions = new ArrayList<Session>();
    }

    public Matiere getMatiere() {
        return matiereT;
    }

    public void setMatiere(Matiere matiere) {
        this.matiereT = matiere;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

}
