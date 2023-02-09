/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.ChaineOfResponsability;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import nfp121_nib_2417n_2419n.Model.Student;

/**
 *
 * @author Georges
 */
public class InformationPayementHandler extends PayementHandler {

    private JFrame frame;
    private JButton b1;
    private JPanel newPanel, newPanel1, radioPanel, newPanel2;
    private JLabel userLabel, passLabel;
    private JTextField textField1, textField2;
 
    InformationPayementHandler() {
      
        userLabel = new JLabel();
        userLabel.setText("Id");      //set label value for textField1  
        frame = new JFrame();
        //create text field to get username from the user  
        textField1 = new JTextField(10);    //set length of the text  
        //create label for password  
        passLabel = new JLabel();
        passLabel.setText("Username");      //set label value for textField2  

        //create text field to get password from the user  
        textField2 = new JTextField(10);    //set length for the password  

        //create submit button  
        b1 = new JButton("Payé facture");
        b1.addActionListener(new PayementFacture());

        //create panel to put form elements  
        newPanel1 = new JPanel(new GridLayout(2, 1));
        radioPanel = new JPanel();
        newPanel2 = new JPanel();
        newPanel1.add(userLabel);    //set username label to panel  
        newPanel1.add(textField1);   //set text field to panel  
        newPanel1.add(radioPanel);
        newPanel1.add(passLabel);    //set password label to panel  
        newPanel1.add(textField2);   //set text field to panel

        newPanel2.add(b1);           //set button to panel  

        newPanel = new JPanel();
        newPanel.add(newPanel1);
        newPanel.add(radioPanel);
        newPanel.add(newPanel2);
        frame.setSize(1000, 100);  //set size of the frame  

        frame.add(newPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        //perform action on button click   

        //set title to the login form  
        frame.setVisible(true);  //make form visible to the user 

    }

    class PayementFacture implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            processRequest();
        }

    }

    @Override
    public void processRequest() {
        if (textField1.getText().trim().isEmpty() || textField2.getText().trim().isEmpty()) {
            JLabel label = new JLabel("The id and the username cannot be empty!");
            label.setFont(new Font("calibri", Font.BOLD, 15));
            JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ((Integer.toString(InscriptionInformation.student.id).equalsIgnoreCase(textField1.getText())) && (InscriptionInformation.student.username.equalsIgnoreCase(textField2.getText()))) {
            setSuccessor(new SelectionHandler());
            frame.setVisible(false);


        } else {
            JLabel label = new JLabel("Please enter your correct id and username!");
            label.setFont(new Font("calibri", Font.BOLD, 15));
            JOptionPane.showMessageDialog(null, label, "ERROE", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

}
