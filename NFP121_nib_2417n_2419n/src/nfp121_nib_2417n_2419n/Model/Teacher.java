/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;
// import nfp121_nib_2417n_2419n.IHM.*;



/**
 *
 * @author Georges
 */
public class Teacher extends Person  {

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
