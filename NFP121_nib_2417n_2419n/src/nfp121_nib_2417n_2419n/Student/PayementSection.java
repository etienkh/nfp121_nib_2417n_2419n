package nfp121_nib_2417n_2419n.Student;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import nfp121_nib_2417n_2419n.ChaineOfResponsability.InscriptionInformation;
import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;

/**
 *
 * @author Georges
 */
public class PayementSection extends Container implements MyObserver {

    private JList matiereInsList;
    private static DefaultListModel matiereInsMod;
    private JScrollPane insScrollPane;
    private static JButton payementBtn;
    //  ArrayList<Person> personList = readAllPerson();
    Student student;

    PayementSection(Student student) {
        this.student = student;
        student.addObserver(this);
        matiereInsMod = new DefaultListModel<Matiere>();
        matiereInsList = new JList<Teacher>(matiereInsMod);
        if (!student.getMatiereIns().isEmpty()) {
            for (int i = 0; i < student.getMatiereIns().size(); i++) {

                matiereInsMod.addElement(student.getMatiereIns().get(i));

            }
        }
        matiereInsList = new JList<Teacher>(matiereInsMod);
        insScrollPane = new JScrollPane(matiereInsList);
        insScrollPane.setBounds(450, 100, 800, 400);
        insScrollPane.setBorder(BorderFactory.createTitledBorder("Matiere inscrit"));
        payementBtn = new JButton("Payement");
        payementBtn.addActionListener(new PayementListener());
        payementBtn.setBounds(750, 520, 150, 20);
        if (student.getPayement()) {
            payementBtn.setEnabled(false);
        }

        this.add(payementBtn);
        this.add(insScrollPane);

    }

    public static DefaultListModel getMatiereInsMod() {
        return matiereInsMod;
    }

    public static JButton getPayementBtn() {
        return payementBtn;
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

    class PayementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            InscriptionInformation concrete = new InscriptionInformation(student);

        }

    }
}
