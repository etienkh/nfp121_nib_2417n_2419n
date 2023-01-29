package nfp121_nib_2417n_2419n.Teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import nfp121_nib_2417n_2419n.Model.Person;

public class TeacherHomePage extends JFrame implements ActionListener {

    public JLabel userLabel;
    public JPanel newPanel1;
    public JPanel newPanel;

    public TeacherHomePage(Person person) {
        JTabbedPane tabbedPane = new JTabbedPane();

        // add tabs to the JTabbedPane
        tabbedPane.addTab("Course", new JLabel("This is tab 1"));
        tabbedPane.addTab("Sessions", new JLabel("This is tab 2"));
        tabbedPane.addTab("View Sessions", new JLabel("This is tab 3"));
        tabbedPane.addTab("Quizes", new QuizSection());

        // add the JTabbedPane to the frame
        this.add(tabbedPane);

        // set the size and location of the frame
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);

        // set the default close operation and make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) //pass action listener as a parameter  
    {
    }

}
