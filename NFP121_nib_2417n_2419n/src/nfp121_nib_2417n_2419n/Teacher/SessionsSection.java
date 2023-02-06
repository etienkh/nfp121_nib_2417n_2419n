/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Teacher;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Session;
import nfp121_nib_2417n_2419n.Model.Teacher;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author User
 */
public class SessionsSection extends JPanel {
    private JLabel titleLabel, dateLabel, startTimeLabel, endTimeLabel;
    private JTextField titleField, dateField, startTimeField, endTimeField;
    private JButton createButton;
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    private Teacher teacher;
    private JFrame frame;
    private Session session;

    public SessionsSection(Teacher teacher, Session session, JFrame frame) {
        this.teacher = teacher;
        this.frame = frame;
        this.session = session;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        titleLabel = new JLabel("Title: ");
        panel1.add(titleLabel);
        titleField = new JTextField(100);
        panel1.add(titleField);

        dateLabel = new JLabel("Date (e.g 01/06/2023 - Day/Month/Year): ");
        panel2.add(dateLabel);
        dateField = new JTextField(30);
        panel2.add(dateField);

        startTimeLabel = new JLabel("Start Time (e.g 14:23 - Hours:Minutes): ");
        panel3.add(startTimeLabel);
        startTimeField = new JTextField(10);
        panel3.add(startTimeField);

        endTimeLabel = new JLabel("End Time (e.g 14:23 - Hours:Minutes): ");
        panel4.add(endTimeLabel);
        endTimeField = new JTextField(10);
        panel4.add(endTimeField);

        createButton = new JButton("Create");
        panel6.add(createButton);
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);

        createButton.addActionListener(new CreateSessionListener());
    }

    public static JPanel getSessionsSection(Teacher teacher, Session session, JFrame frame) {
        return new SessionsSection(teacher, session, frame);
    }

    private class CreateSessionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (titleField.getText().isEmpty() || dateField.getText().isEmpty() || startTimeField.getText().isEmpty()
                    || endTimeField.getText().isEmpty()) {
                JLabel label = new JLabel("All field are required!");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
                List<MyObserver> obss = session.getObservers();
                session = new Session(UUID.randomUUID().toString(),
                        titleField.getText(),
                        LocalDate.parse(dateField.getText(), formatter),
                        LocalTime.parse(startTimeField.getText(), formatter2),
                        LocalTime.parse(endTimeField.getText(), formatter2));
                for (MyObserver obs : obss) {
                    session.addObserver(obs);
                }
                ArrayList<Session> sessions = teacher.getSessions();
                Session clone = new Session(session.getSessionId(), session.getName(), session.getDate(),
                session.getStartTime(), session.getEndTime());
                sessions.add(clone);
                teacher.setSessions(sessions);
                session.setName(titleField.getText());
                try {
                    InputOutputPerson.updatePerson(teacher);
                    JLabel label2 = new JLabel("Session is scheduled!");
                    label2.setFont(new Font("calibri", Font.BOLD, 15));
                    JOptionPane.showMessageDialog(frame, label2);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}
