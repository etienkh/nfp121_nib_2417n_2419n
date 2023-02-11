/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.Student;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Teacher.CourseSection;

/**
 *
 * @author Georges
 */
public class StudentCourseSection extends JFrame {

    private JLabel nameLab, codeLab, title;
    private JTextField nameField, codeField;
    private JTable objectifTab, syllabusTab, chapitreTab;
    private DefaultTableModel objectifModel, syllabusModel, chapitreModel;
    private JScrollPane objectifPane, syllabusPane, chapitrePane, documentScrollPane;
    private JList documentList;
    private DefaultListModel documentModel;
    Matiere matiere;
    private Container c;

    StudentCourseSection(Matiere matiere) {
        this.matiere = matiere;
        c = getContentPane();
        this.setSize(1700, 800);
        c.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        title = new JLabel("Course Info");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);

        nameLab = new JLabel("Name:");
        nameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLab.setSize(100, 20);
        nameLab.setLocation(100, 100);
        c.add(nameLab);

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(150, 20);
        nameField.setLocation(160, 100);
        nameField.setEditable(false);
        nameField.setText(matiere.getName());
        c.add(nameField);

        codeLab = new JLabel("Code:");
        codeLab.setFont(new Font("Arial", Font.PLAIN, 20));
        codeLab.setSize(100, 20);
        codeLab.setLocation(100, 150);
        c.add(codeLab);

        codeField = new JTextField(15);
        codeField.setFont(new Font("Arial", Font.PLAIN, 15));
        codeField.setSize(150, 20);
        codeField.setLocation(160, 150);
        codeField.setText(matiere.getCode());
        codeField.setEditable(false);
        c.add(codeField);

        String[] columnObjectif = {"Objectif"};
        String objectifData[][] = new String[11][1];
        if (matiere != null) {
            ;
            for (int i = 0; i < objectifData.length && i < matiere.getObjectifs().size(); i++) {

                objectifData[i][0] = matiere.getObjectifs().get(i);
            }
        }

        objectifModel = new DefaultTableModel(objectifData, columnObjectif);
        objectifTab = new JTable(objectifModel);
        objectifTab.setEnabled(false);
        objectifPane = new JScrollPane(objectifTab);
        objectifPane.setBounds(350, 100, 300, 200);

        c.add(objectifPane);

        String[] columnSyllabus = {"syllabus"};
        String syllabusData[][] = new String[11][1];
        if (matiere != null) {
            ;
            for (int i = 0; i < syllabusData.length && i < matiere.getSyllabus().size(); i++) {

                syllabusData[i][0] = matiere.getSyllabus().get(i);
            }
        }
        syllabusModel = new DefaultTableModel(syllabusData, columnSyllabus);
        syllabusTab = new JTable(syllabusModel);
        syllabusTab.setEnabled(false);
        syllabusPane = new JScrollPane(syllabusTab);

        syllabusPane.setBounds(660, 100, 300, 200);
                

        syllabusPane.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    syllabusModel.addRow(new Object[]{""});
                }
            }

        });
        c.add(syllabusPane);

        String[] columnChapitre = {"chapitre"};

        String chapitreData[][] = new String[11][1];
        if (matiere != null) {

            for (int i = 0; i < chapitreData.length && i < matiere.getChapitres().size(); i++) {

                chapitreData[i][0] = matiere.getChapitres().get(i);
            }
        }
        chapitreModel = new DefaultTableModel(chapitreData, columnChapitre);
        chapitreTab = new JTable(chapitreModel);
        chapitreTab.setEnabled(false);
        chapitrePane = new JScrollPane(chapitreTab);
        chapitrePane.setBounds(970, 100, 300, 200);

        c.add(chapitrePane);

        documentModel = new DefaultListModel<File>();

        if (matiere != null) {
            for (int i = 0; i < matiere.getDocuments().size(); i++) {
                documentModel.addElement(matiere.getDocuments().get(i));
            }
        }
        documentList = new JList<File>(documentModel);
        documentScrollPane = new JScrollPane(documentList);
        documentScrollPane.setBounds(1300, 100, 300, 200);
        documentScrollPane.setBorder(BorderFactory.createTitledBorder("Documents"));
        documentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    File selectedFile = (File) documentList.getSelectedValue();
                    if (selectedFile != null) {
                        try {
                            Desktop.getDesktop().open(selectedFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        c.add(documentScrollPane);
        
        

    }

}
