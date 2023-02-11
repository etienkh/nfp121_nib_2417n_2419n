/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.Student;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Student;
import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;
import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Session;
import nfp121_nib_2417n_2419n.Model.Teacher;

/**
 *
 * @author Georges
 */
public class SessionsSectionsStud extends JPanel implements MyObserver {

    Student student;
    private ArrayList<Matiere> studMatiereList;
    private JPanel panel;
    private DefaultListModel model;
    private JList list;
    private JTable table;
    private ArrayList<Person> personList = readAllPerson();

    public JPanel getPanel() {
        return panel;
    }

    public SessionsSectionsStud(Student student, JFrame frame) {
        this.student = student;
        student.addObserver(this);
        studMatiereList = student.getMatiereIns();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        model = new DefaultListModel<Session>();
        int s = 0;
        String[] columns = {"Matiere", "Session Number", "Session Name"};
       
        
        for (int j = 0; j < personList.size(); j++) {
            for (int i = 0; i < studMatiereList.size(); i++) {
                if (personList.get(j).getClass() == Teacher.class) {
                    Teacher teacher = (Teacher) personList.get(j);

                    if (((studMatiereList.get(i).getCode().equalsIgnoreCase(teacher.getMatiere().getCode())) && ((studMatiereList.get(i).getName().equalsIgnoreCase(teacher.getMatiere().getName()))))) {
                        for (int k = 0; k < teacher.getSessions().size(); k++) {
                            model.addElement(teacher.getSessions().get(k));

                        }

                    }

                }

            }

        }

        list = new JList<Session>(model);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Session disponible"));
        panel.add(scrollPane, BorderLayout.CENTER);
        JButton button = new JButton("Join");

        button.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {

                Session session = (Session) list.getSelectedValue();
                if (session == null) {
                    JLabel label = new JLabel("Please select a session to join!");
                    label.setFont(new Font("calibri", Font.BOLD, 15));
                    JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (int j = 0; j < personList.size(); j++) {
                    if (personList.get(j).getClass() == Teacher.class) {
                        Teacher teacher = (Teacher) personList.get(j);
                        for (int i = 0; i < studMatiereList.size(); i++) {
                            if (((studMatiereList.get(i).getCode().equalsIgnoreCase(teacher.getMatiere().getCode())) && ((studMatiereList.get(i).getName().equalsIgnoreCase(teacher.getMatiere().getName()))))) {
                                for (int s = 0; s < session.getAttendees().size(); s++) {
                                    if (session.getAttendees().get(s).username.equalsIgnoreCase(student.username)) {

                                        JLabel label = new JLabel("You already joined this course!");
                                        label.setFont(new Font("calibri", Font.BOLD, 15));
                                        JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                                        return;
                                    }
                                }

                                try {
                                    session.getAttendees().add(student);
                                    InputOutputPerson.updatePerson(teacher);
                                    JLabel label2 = new JLabel("You joined the session");
                                    label2.setFont(new Font("calibri", Font.BOLD, 15));
                                    JOptionPane.showMessageDialog(frame, label2);
                                    return;
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    }

                }

            }

        }
        );

        panel.add(button, BorderLayout.SOUTH);

        this.add(panel);
    }

    public static JPanel getSessionsSection(Student student, JFrame frame) {
        return new SessionsSectionsStud(student, frame);
    }

    @Override
    public void update(MyObservable obs, Object obj) {
        model.clear();
        for (int j = 0; j < personList.size(); j++) {
            for (int i = 0; i < studMatiereList.size(); i++) {
                if (personList.get(j).getClass() == Teacher.class) {
                    Teacher teacher = (Teacher) personList.get(j);

                    if (((studMatiereList.get(i).getCode().equalsIgnoreCase(teacher.getMatiere().getCode())) && ((studMatiereList.get(i).getName().equalsIgnoreCase(teacher.getMatiere().getName()))))) {
                        for (int k = 0; k < teacher.getSessions().size(); k++) {
                            model.addElement(teacher.getSessions().get(k));

                        }

                    }

                }

            }

        }

    }

}
