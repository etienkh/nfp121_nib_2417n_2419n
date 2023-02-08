/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

import java.util.ArrayList;

/**
 *
 * @author Georges
 */
public class Student extends Person {

    private ArrayList<Matiere> matiereIns;
    private Boolean payement;

    public Student(String username, String firstName, String lastName, String password) {
        super(username, firstName, lastName, password);
        this.matiereIns = new ArrayList<Matiere>();
        
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
        return "";
    }

}
