/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.ChaineOfResponsability;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Student.PayementSection;
import nfp121_nib_2417n_2419n.Student.ViewCourse;

/**
 *
 * @author Georges
 */
public class ConfirmationHandler extends PayementHandler {

    Student student;
    JPanel panel;
    JLabel label;
    JTextField textField;

    public ConfirmationHandler() {

        panel = new JPanel();
        label = new JLabel("Enter the payment amount:");
        textField = new JTextField(10);
        panel.add(label);
        panel.add(textField);

        int confirm = JOptionPane.showConfirmDialog(null, panel, "Payment Confirmation", JOptionPane.OK_CANCEL_OPTION);
        if (confirm == JOptionPane.OK_OPTION) {
            String paymentAmount = textField.getText();
            // code to process payment
            if (paymentAmount.equalsIgnoreCase(Integer.toString(InscriptionInformation.priceTot))) {
                JOptionPane.showMessageDialog(null, "Payment of $" + paymentAmount + " successful!");
                processRequest();
            } else {
                JOptionPane.showMessageDialog(null, "Payment cancelled!");
            }
        }

    }

    @Override
    public void processRequest() {
        PayementSection.getPayementBtn().setEnabled(false);
        ViewCourse.getAccessCourseBtn().setEnabled(true);
        InscriptionInformation.student.setPayement(Boolean.TRUE);
        try {
            InputOutputPerson.updatePerson(InscriptionInformation.student);
        } catch (IOException ex) {
            Logger.getLogger(ConfirmationHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
