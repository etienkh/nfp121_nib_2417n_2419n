/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.ChaineOfResponsability;

import javax.swing.JOptionPane;
import nfp121_nib_2417n_2419n.Model.Student;

/**
 *
 * @author Georges
 */
public class SelectionHandler extends PayementHandler {

    Student student;

    public SelectionHandler() {
        this.student = student;
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed with the payement ?");
        if (option == JOptionPane.YES_OPTION) {
            processRequest();
        }

    }

    @Override
    public void processRequest() {
        new ConfirmationHandler();

    }

}
