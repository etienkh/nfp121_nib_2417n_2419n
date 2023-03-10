package nfp121_nib_2417n_2419n.IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nfp121_nib_2417n_2419n.Model.Person;

public class HomePage extends JFrame  {

    public JLabel userLabel;
    public JPanel newPanel1;
    public JPanel newPanel;

    public HomePage(Person person) {
        userLabel = new JLabel();
        userLabel.setText(person.firstName);
        newPanel1 = new JPanel(new GridLayout(2, 1));
        newPanel1.add(userLabel);

        newPanel = new JPanel();
        newPanel.add(newPanel1);
        this.add(newPanel, BorderLayout.CENTER);
        this.setSize(500, 500);
        //perform action on button click   
        setTitle("Home page");         //set title to the login form  
        this.setLocationRelativeTo(null);
        JLabel wel_label = new JLabel("Welcome: " + person.getClass().getSimpleName());
        newPanel.add(wel_label);
        this.add(newPanel);
        this.setVisible(true);
    }

    

}
