/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n;

/**
 *
 * @author Georges
 */

// Java program to implement
// a Simple Registration Form
// using Java Swing
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
   class registrationForm extends JFrame
{
     
 
    // Components of the Form
    private Container c;
    private JFrame frame;
    private JLabel usernameLab,title,passwordLab,firstNameLab,lastNameLab;
    private JTextField usernameField,lastNameField,firstNameField,passwordField;
    private JRadioButton student,teacher;
    private ButtonGroup gengp;
    private JButton sub;
    // constructor, to initialize the components
    // with default values.
    registrationForm()
    {
         
        frame = new JFrame("Registration");
        frame.setSize(1000,300);
        
        c = getContentPane();
        c.setLayout(null);
        
        title = new JLabel("Create Account");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);
        
        usernameLab = new JLabel("User Name");
        usernameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLab.setSize(100, 20);
        usernameLab.setLocation(100, 100);
        c.add(usernameLab);
 
        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField.setSize(150, 20);
        usernameField.setLocation(200, 100);
        c.add(usernameField);
 
        passwordLab = new JLabel("Password");
        passwordLab.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLab.setSize(100, 20);
        passwordLab.setLocation(100, 150);
        c.add(passwordLab);
 
        passwordField = new JTextField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(150, 20);
        passwordField.setLocation(200, 150);
        c.add(passwordField);
 
        student = new JRadioButton("Student");
        student.setFont(new Font("Arial", Font.PLAIN, 15));
        student.setSelected(true);
        student.setSize(75, 20);
        student.setLocation(200, 200);
        c.add(student);
 
        teacher = new JRadioButton("Teacher");
        teacher.setFont(new Font("Arial", Font.PLAIN, 15));
        teacher.setSelected(false);
        teacher.setSize(80, 20);
        teacher.setLocation(275, 200);
        c.add(teacher);
 
        gengp = new ButtonGroup();
        gengp.add(student);
        gengp.add(teacher);

        firstNameLab = new JLabel("First Name");
        firstNameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        firstNameLab.setSize(150, 20);
        firstNameLab.setLocation(100, 250);
        c.add(firstNameLab);
         
        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNameField.setSize(150, 20);
        firstNameField.setLocation(200, 250);
        c.add(firstNameField);
        
        lastNameLab = new JLabel("Last Name");
        lastNameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        lastNameLab.setSize(150, 20);
        lastNameLab.setLocation(100, 300);
        c.add(lastNameLab);
        
        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameField.setSize(150, 20);
        lastNameField.setLocation(200, 300);
        c.add(lastNameField);
        
        sub = new JButton("Register");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(200, 350);
       
        c.add(sub);
           
        frame.add(c);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }
    } 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    
// Driver Code