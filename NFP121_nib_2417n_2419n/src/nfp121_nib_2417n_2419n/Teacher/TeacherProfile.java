/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.Teacher;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import nfp121_nib_2417n_2419n.Model.Teacher;

/**
 *
 * @author Georges
 */
public class TeacherProfile extends Container {

    // Components of the Form

    private JLabel usernameLab, title;
    private JTextField usernameField, lastNameField, firstNameField;
    private JTextField idField;
    private JLabel idLab, firstNameLab, lastNameLab;

    // constructor, to initialize the components
    // with default values.
    TeacherProfile(Teacher teacher) {

        title = new JLabel("Profile");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        this.add(title);

        usernameLab = new JLabel("User Name");
        usernameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLab.setSize(100, 20);
        usernameLab.setLocation(100, 100);
        this.add(usernameLab);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField.setText(teacher.username);
        usernameField.setEditable(false);
        usernameField.setSize(150, 20);
        usernameField.setLocation(200, 100);
        this.add(usernameField);

        idLab = new JLabel("Id");
        idLab.setFont(new Font("Arial", Font.PLAIN, 20));
        idLab.setSize(100, 20);
        idLab.setLocation(100, 150);
        this.add(idLab);

        idField = new JTextField();
        idField.setText(Integer.toString(teacher.id));
        idField.setEditable(false);
        idField.setFont(new Font("Arial", Font.PLAIN, 15));
        idField.setSize(150, 20);
        idField.setLocation(200, 150);
        this.add(idField);

        firstNameLab = new JLabel("First Name");
        firstNameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        firstNameLab.setSize(150, 20);
        firstNameLab.setLocation(100, 200);
        this.add(firstNameLab);

        firstNameField = new JTextField();
        firstNameField.setText(teacher.firstName);
        firstNameField.setEditable(false);
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNameField.setSize(150, 20);
        firstNameField.setLocation(200, 200);
        this.add(firstNameField);

        lastNameLab = new JLabel("Last Name");
        lastNameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        lastNameLab.setSize(150, 20);
        lastNameLab.setLocation(100, 250);
        this.add(lastNameLab);

        lastNameField = new JTextField();
        lastNameField.setText(teacher.lastName);
        lastNameField.setEditable(false);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameField.setSize(150, 20);
        lastNameField.setLocation(200, 250);
        this.add(lastNameField);



    }

}
