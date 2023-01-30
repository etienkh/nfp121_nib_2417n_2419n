/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Teacher;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Georges
 */
public class CourseSection extends Container {

    private JLabel nameLab, priceLab, codeLab, creditLab, title;
    private JTextField nameField, priceField, codeField, creditField;
    private JButton submitButton;
    private JPanel panel1;
    private Container c;

    public CourseSection() {
        
       
        title = new JLabel("Create Account");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        this.add(title);

        nameLab = new JLabel("User Name");
        nameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLab.setSize(100, 20);
        nameLab.setLocation(100, 100);
        this.add(nameLab);

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(150, 20);
        nameField.setLocation(200, 100);
        this.add(nameField);
        // Set form layout and properties
        this.setVisible(true);
    }
}
