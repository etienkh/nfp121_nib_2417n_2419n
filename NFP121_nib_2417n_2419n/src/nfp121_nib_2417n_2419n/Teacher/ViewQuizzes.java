package nfp121_nib_2417n_2419n.Teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Teacher;

public class ViewQuizzes {

    static class ViewQuizzesView implements MyObserver {

        private Teacher teacher;
        private JPanel panel;
        private DefaultTableModel model;
        private JTable table;

        public JPanel getPanel() {
            return panel;
        }

        ViewQuizzesView(Teacher teacher, JFrame frame) {
            this.teacher = teacher;

            panel = new JPanel();
            panel.setLayout(new BorderLayout());

            String[] columns = { "Quiz Number", "Quiz Name" };
            Object[][] data;
            if (teacher.getMatiere() != null) {
                ArrayList<Quiz> quizzes = teacher.getMatiere().getQuizzes();
                data = new Object[quizzes.size()][2];
                for (int i = 0; i < quizzes.size(); i++) {
                    data[i][0] = i + 1;
                    data[i][1] = quizzes.get(i).getQuizTitle();
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
                    } else if (teacher.getMatiere() != null && teacher.getMatiere().getQuizzes().size() > 0) {
                        JDialog dialog = new JDialog(frame, "Information");
                        dialog.setSize(new Dimension(200, 150));
                        dialog.setLocationRelativeTo(frame);
                        JOptionPane.showMessageDialog(dialog,
                                teacher.getMatiere().getQuizzes().get(selectedRow).toString());
                    }
                }
            });
            panel.add(button, BorderLayout.SOUTH);
            this.teacher.getMatiere().addObserver(this);
        }

        @Override
        public void update(MyObservable obs, Object obj) {
            ArrayList<Quiz> quizzes = teacher.getMatiere().getQuizzes();
            Object[][] data = new Object[quizzes.size()][2];
            for (int i = 0; i < quizzes.size(); i++) {
                data[i][0] = i + 1;
                data[i][1] = quizzes.get(i).getQuizTitle();
            }
            String[] columns = { "Quiz Number", "Quiz Name" };
            model = new DefaultTableModel(data, columns);
            table.setModel(model);
        }
    }

    public static JPanel QuizzesViewer(Teacher teacher, JFrame frame) {
        ViewQuizzesView view = new ViewQuizzesView(teacher, frame);
        return view.getPanel();
    }
}
