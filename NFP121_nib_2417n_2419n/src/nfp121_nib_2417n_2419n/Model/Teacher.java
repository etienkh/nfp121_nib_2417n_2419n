package nfp121_nib_2417n_2419n.Model;

public class Teacher extends Person {

    private Matiere matiereT;

    public Teacher(String username, String firstName, String lastName, String password, Matiere matiereT) {
        super(username, firstName, lastName, password);
        this.matiereT = matiereT;
    }

    public Matiere getMatiere() {
        return matiereT;
    }

    public void setMatiere(Matiere matiere) {
        this.matiereT = matiere;
    }

}
