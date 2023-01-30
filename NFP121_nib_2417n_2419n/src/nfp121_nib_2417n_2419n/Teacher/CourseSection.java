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
    private JButton updateCourseBtn;
    private JPanel panel1;
    private Container c;

    public CourseSection() {

        title = new JLabel("Course Info");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        this.add(title);

        nameLab = new JLabel("Name:");
        nameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLab.setSize(100, 20);
        nameLab.setLocation(100, 100);
        this.add(nameLab);

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(150, 20);
        nameField.setLocation(160, 100);
        this.add(nameField);

        codeLab = new JLabel("Code:");
        codeLab.setFont(new Font("Arial", Font.PLAIN, 20));
        codeLab.setSize(100, 20);
        codeLab.setLocation(100, 150);
        this.add(codeLab);

        codeField = new JTextField(15);
        codeField.setFont(new Font("Arial", Font.PLAIN, 15));
        codeField.setSize(150, 20);
        codeField.setLocation(160, 150);
        this.add(codeField);

        creditLab = new JLabel("Credit:");
        creditLab.setFont(new Font("Arial", Font.PLAIN, 20));
        creditLab.setSize(100, 20);
        creditLab.setLocation(100, 200);
        this.add(creditLab);

        creditField = new JTextField(15);
        creditField.setFont(new Font("Arial", Font.PLAIN, 15));
        creditField.setSize(150, 20);
        creditField.setLocation(160, 200);
        this.add(creditField);

        priceLab = new JLabel("Price:");
        priceLab.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLab.setSize(100, 20);
        priceLab.setLocation(100, 250);
        this.add(priceLab);

        priceField = new JTextField(15);
        priceField.setFont(new Font("Arial", Font.PLAIN, 15));
        priceField.setSize(150, 20);
        priceField.setLocation(160, 250);
        priceField.setEnabled(false);
        this.add(priceField);

        updateCourseBtn = new JButton("Update Course");
        updateCourseBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        updateCourseBtn.setSize(150, 20);
        updateCourseBtn.setLocation(160, 300);
        this.add(updateCourseBtn);

        // Set form layout and properties
        this.setVisible(true);
    }
}
