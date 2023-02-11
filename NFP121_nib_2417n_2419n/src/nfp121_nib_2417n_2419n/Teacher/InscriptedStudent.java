/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.Teacher;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Student.InscriptionSection;

/**
 *
 * @author Georges
 */
public class InscriptedStudent extends Container {

    private DefaultListModel studentModel;
    private JScrollPane studentScrollPane;
    private JList studentList;
    ArrayList<Person> personList = readAllPerson();
    Teacher teacher;

    public InscriptedStudent(Teacher teacher) {
        this.teacher = teacher;
        studentModel = new DefaultListModel<Student>();
        Matiere matiere = teacher.getMatiere();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getClass() == Student.class) {
                Student student = (Student) personList.get(i);
                for (int j = 0; j < student.getMatiereIns().size(); j++) {

                    try {
                        if ((matiere.getCode().equals(student.getMatiereIns().get(j).getCode()) && (matiere.getName().equals(student.getMatiereIns().get(j).getName())))) {
                            studentModel.addElement(student);
                        }
                    } catch (NullPointerException npe) {

                    }
                }
            }

        }

        studentList = new JList<Student>(studentModel);
        studentScrollPane = new JScrollPane(studentList);

        studentScrollPane.setBounds(
                450, 100, 800, 400);
        studentScrollPane.setBorder(BorderFactory.createTitledBorder("Etudiant inscrit"));

        this.add(studentScrollPane);

    }
}
