/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.Student;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;

/**
 *
 * @author Georges
 */
public class Note extends Container implements Observer {

    JTable table;
    JScrollPane scrollPane;
    ArrayList<Person> personList = readAllPerson();
    Object[][] data;

    public Note(Student student) {
        String column[] = {"Code Matiere", "Note", "Quiz Title"};
        
        if (student.getResultats() != null) {
            data = new Object[student.getResultats().size()][3];
        } else {
            data = new Object[1][3];
        }
        if (student.getResultats() != null) {
            for (int i = 0; i < student.getResultats().size(); i++) {
                data[i][0] = student.getResultats().get(i).getMatiereTitle();

                data[i][1] = student.getResultats().get(i).getNote();

                data[i][2] = student.getResultats().get(i).getQuizTitle();
            }
        } else {
            data[0][0] = "";
            data[0][1] = "";
            data[0][2] = "";
        }
    

        
        table  = new JTable(data, column);
    scrollPane  = new JScrollPane(table);

    scrollPane.setEnabled (

    false);
    scrollPane.setSize (

    1000, 600);
    scrollPane.setBorder (BorderFactory.createTitledBorder
    ("Notes"));
         

    this.setLayout(
    new BorderLayout());
         

    this.add(scrollPane, BorderLayout.CENTER);
}

@Override
public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
