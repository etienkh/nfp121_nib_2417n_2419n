
package nfp121_nib_2417n_2419n.Student;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import nfp121_nib_2417n_2419n.ChaineOfResponsability.InscriptionInformation;
import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;
import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;

/**
 *
 * @author Georges
 */
public class ViewCourse extends Container implements MyObserver {

    private JList matiereInsList;
    private static DefaultListModel matiereInsMod;
    private JScrollPane insScrollPane;
    private static JButton accessCourseBtn;
    //  ArrayList<Person> personList = readAllPerson();
    Student student;

    ViewCourse(Student student) {
        this.student = student;
        student.addObserver(this);
        matiereInsMod = new DefaultListModel<Matiere>();
        
        if (!student.getMatiereIns().isEmpty()) {
            for (int i = 0; i < student.getMatiereIns().size(); i++) {

                matiereInsMod.addElement(student.getMatiereIns().get(i));

            }
        }
        matiereInsList = new JList<Matiere>(matiereInsMod);
        insScrollPane = new JScrollPane(matiereInsList);
        insScrollPane.setBounds(450, 100, 800, 400);
        insScrollPane.setBorder(BorderFactory.createTitledBorder("Matiere inscrit"));
       

        accessCourseBtn = new JButton("View Course");
        if (!student.getPayement()) {
            accessCourseBtn.setEnabled(false);
        }
        accessCourseBtn.setBounds(750, 520, 150, 20);
        accessCourseBtn.addActionListener(new AccessCourseListener());
       
        this.add(accessCourseBtn);
       
        this.add(insScrollPane);

    }

    public static DefaultListModel getMatiereInsMod() {
        return matiereInsMod;
    }


    @Override
    public void update(MyObservable obs, Object obj) {
        matiereInsMod.clear();
        if (!student.getMatiereIns().isEmpty()) {
            for (int i = 0; i < student.getMatiereIns().size(); i++) {

                matiereInsMod.addElement(student.getMatiereIns().get(i));

            }

        }
        matiereInsList.setModel(matiereInsMod);

    }
    public static JButton getAccessCourseBtn(){
        return accessCourseBtn;
    }


    class AccessCourseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Matiere matiere = (Matiere) matiereInsList.getSelectedValue();
            if (matiere != null) {
                System.out.println(matiere);
                new StudentCourseSection(matiere);

            } else {
                JLabel label = new JLabel("Please select a course!");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                return;

            }
        }
    }
}