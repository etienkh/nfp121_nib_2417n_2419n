package nfp121_nib_2417n_2419n.Teacher;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Session;
import nfp121_nib_2417n_2419n.Model.Teacher;

public class ViewSessions {

    static class ViewSessionsViewer implements MyObserver {

        private Teacher teacher;
        private JPanel panel;
        private DefaultTableModel model;
        private JTable table;

        public JPanel getPanel() {
            return panel;
        }

        ViewSessionsViewer(Teacher teacher, Session session, JFrame frame) {
            this.teacher = teacher;

            panel = new JPanel();
            panel.setLayout(new BorderLayout());

            String[] columns = { "Quiz Number", "Quiz Name" };
            Object[][] data;
            if (teacher.getSessions().size() > 0) {
                ArrayList<Session> quizzes = teacher.getSessions();
                data = new Object[quizzes.size()][2];
                for (int i = 0; i < quizzes.size(); i++) {
                    data[i][0] = quizzes.get(i).getSessionId();
                    data[i][1] = quizzes.get(i).getName();
                }
            } else {
                data = new Object[0][0];
            }

            model = new DefaultTableModel(data, columns);
            table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            JButton button = new JButton("View");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(frame, "Please select a row.");
                    } else if (teacher.getSessions().size() > 0) {
                        JDialog dialog = new JDialog(frame, "Information");
                        dialog.setSize(new Dimension(200, 150));
                        dialog.setLocationRelativeTo(frame);
                        JOptionPane.showMessageDialog(dialog,
                                teacher.getSessions().get(selectedRow).toString());
                    }
                }
            });
            panel.add(button, BorderLayout.SOUTH);
            session.addObserver(this);
        }

        @Override
        public void update(MyObservable obs, Object obj) {
            ArrayList<Session> quizzes = teacher.getSessions();
            Object[][] data = new Object[quizzes.size()][2];
            data = new Object[quizzes.size()][2];
            for (int i = 0; i < quizzes.size(); i++) {
                data[i][0] = quizzes.get(i).getSessionId();
                data[i][1] = quizzes.get(i).getName();
            }
            String[] columns = { "Session Id", "Session Name" };
            model = new DefaultTableModel(data, columns);
            table.setModel(model);
        }
    }

    public static JPanel SessionsController(Teacher teacher, Session session, JFrame frame) {
        ViewSessionsViewer view = new ViewSessionsViewer(teacher, session, frame);
        return view.getPanel();
    }
}
