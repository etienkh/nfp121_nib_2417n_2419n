/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.Student;

import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;

/**
 *
 * @author Georges
 */
public class InscriptionSection extends Container {

    private JList matiereDisTab;
    private DefaultListModel matiereDisMod;
    private final JScrollPane insScrollPane;
    private JButton inscriptionBtn;
    ArrayList<Person> personList = readAllPerson();
    Student student;

    public InscriptionSection(Student student) {
        this.student = student;
        matiereDisMod = new DefaultListModel<Teacher>();
        System.out.println(student.getMatiereIns());
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getClass() == Teacher.class) {
                Teacher teacher = (Teacher) personList.get(i);
                if (teacher.getMatiere() != null) {
                    matiereDisMod.addElement(personList.get(i));
                }
            }
        }
        matiereDisTab = new JList<Teacher>(matiereDisMod);
        insScrollPane = new JScrollPane(matiereDisTab);
        insScrollPane.setBounds(450, 100, 800, 400);
        insScrollPane.setBorder(BorderFactory.createTitledBorder("Matiere Disponible"));
        inscriptionBtn = new JButton("Inscription");
        inscriptionBtn.addActionListener(new InscriptionListener());
        inscriptionBtn.setBounds(750, 520, 150, 20);
        this.add(inscriptionBtn);
        this.add(insScrollPane);

    }

    class InscriptionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Boolean matiereChoisit = true;
            Teacher teacher = (Teacher) matiereDisTab.getSelectedValue();

            if (teacher == null) {
                JLabel label = new JLabel("Please select a course!");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (Matiere matiere : student.getMatiereIns()) {
                if ((matiere.getCode().equalsIgnoreCase(teacher.getMatiere().getCode())) && (matiere.getName().equalsIgnoreCase(teacher.getMatiere().getName()))) {
                    JLabel label = new JLabel("This course is already added!");
                    label.setFont(new Font("calibri", Font.BOLD, 15));
                    JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            student.addMatiereIns(teacher.getMatiere());
            student.setPayement(Boolean.FALSE);
            JLabel label = new JLabel("This course has been successfuly added !");
            label.setFont(new Font("calibri", Font.BOLD, 15));
            JOptionPane.showMessageDialog(null, label, "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(student.getMatiereIns().size());
            PayementSection.getPayementBtn().setEnabled(true);
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getClass() == Student.class) {
                
                        try {
                            InputOutputPerson.updatePerson(student);
                            return;
                        } catch (IOException ex) {
                            Logger.getLogger(InscriptionSection.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        }

    }


