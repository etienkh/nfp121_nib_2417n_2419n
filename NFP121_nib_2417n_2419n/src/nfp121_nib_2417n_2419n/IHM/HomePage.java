package nfp121_nib_2417n_2419n.IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nfp121_nib_2417n_2419n.Model.Person;

public class HomePage extends JFrame implements ActionListener {

    public JLabel userLabel;
    public JPanel newPanel1;
    public JPanel newPanel;

    public HomePage(Person person) {
        userLabel = new JLabel();
        userLabel.setText(person.toString());
        newPanel1 = new JPanel(new GridLayout(2, 1));
        newPanel1.add(userLabel);

        newPanel = new JPanel();
        newPanel.add(newPanel1);
        this.add(newPanel, BorderLayout.CENTER);
        this.setSize(500, 500);
        //perform action on button click   
        setTitle("Home page");         //set title to the login form  
        this.setLocationRelativeTo(null);
        JLabel wel_label = new JLabel("Welcome: " + person.getClass());
        newPanel.add(wel_label);
        this.add(newPanel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) //pass action listener as a parameter  
    {
    }

}
