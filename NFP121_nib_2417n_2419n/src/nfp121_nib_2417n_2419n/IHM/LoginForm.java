package nfp121_nib_2417n_2419n.IHM;

import nfp121_nib_2417n_2419n.Teacher.TeacherHomePage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;
import static nfp121_nib_2417n_2419n.Singleton.PersonSingleton.getInstance;

class LoginForm extends JFrame implements ActionListener {

    private JButton b1, b2;
    private JPanel newPanel, newPanel1, radioPanel, newPanel2;
    private JLabel userLabel, passLabel;
    private JTextField textField1, textField2;
    private JRadioButton stud, teach;

    //calling constructor  
    LoginForm() {

        //create label for username   
        userLabel = new JLabel();
        userLabel.setText("Username");      //set label value for textField1  

        //create text field to get username from the user  
        textField1 = new JTextField(10);    //set length of the text  
        //create label for password  
        passLabel = new JLabel();
        passLabel.setText("Password");      //set label value for textField2  

        //create text field to get password from the user  
        textField2 = new JPasswordField(10);    //set length for the password  

        //create submit button  
        b1 = new JButton("LOGIN"); //set label to button  
        b2 = new JButton("CREATE ACCOUNT");
        b2.addActionListener(new regFormActionListener());
        //create panel to put form elements  
        newPanel1 = new JPanel(new GridLayout(2, 1));
        radioPanel = new JPanel();
        newPanel2 = new JPanel();
        newPanel1.add(userLabel);    //set username label to panel  
        newPanel1.add(textField1);   //set text field to panel  
        newPanel1.add(radioPanel);
        newPanel1.add(passLabel);    //set password label to panel  
        newPanel1.add(textField2);   //set text field to panel
        stud = new JRadioButton("Student");
        teach = new JRadioButton("Teacher");
        ButtonGroup group = new ButtonGroup();
        group.add(stud);
        group.add(teach);
        radioPanel.add(stud);
        radioPanel.add(teach);
        newPanel2.add(b1);           //set button to panel  
        newPanel2.add(b2);
        newPanel = new JPanel();
        newPanel.add(newPanel1);
        newPanel.add(radioPanel);
        newPanel.add(newPanel2);
        this.setSize(1000, 100);  //set size of the frame  

        this.add(newPanel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("LOGIN FORM");         //set title to the login form  
        this.setVisible(true);  //make form visible to the user 
    }

    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae) //pass action listener as a parameter  
    {
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  

        ArrayList<Person> allPersons = readAllPerson();
        //check whether the credentials are authentic or not  
        boolean isPersonExists = allPersons.stream().filter(i -> i.username.equalsIgnoreCase(userValue) && i.password.equalsIgnoreCase(passValue)).count() > 0;

        if (isPersonExists) {  //if authentic, navigate user to a new page  
            Person p = allPersons.stream().filter(i -> i.username.equalsIgnoreCase(userValue) && i.password.equalsIgnoreCase(passValue)).findFirst().get();
            try {
                Person per = getInstance(p, stud.isSelected() ? "student" : "teacher");
                if (per.getClass() == Student.class) {
                    System.out.println("Student Home Page");
                } else {
                    TeacherHomePage teacherHomePage = new TeacherHomePage((Teacher) per);
                }
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JLabel label = new JLabel("The user name or password is invalid!");
            label.setFont(new Font("calibri", Font.BOLD, 15));
            JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}

class regFormActionListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {

        registrationFormIHM r = new registrationFormIHM();

    }
}
