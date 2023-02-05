package nfp121_nib_2417n_2419n.Teacher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import nfp121_nib_2417n_2419n.Model.Teacher;

public class ViewQuizzes {

    static class ViewQuizzesView implements MyObserver {

        private Teacher teacher;
        private JPanel panel;

        public JPanel getPanel() {
            return panel;
        }

        ViewQuizzesView(Teacher teacher, JFrame frame) {
            this.teacher = teacher;

            panel = new JPanel();
            panel.setLayout(new BorderLayout());

            String[] columns = {"Number", "Text"};
            Object[][] data = {
                {1, "Text 1"},
                {2, "Text 2"},
                {3, "Text 3"},
                {4, "Text 4"},
                {5, "Text 5"},
                {6, "Text 6"}
            };

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);

            JButton button = new JButton("View");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(frame, "Please select a row.");
                    } else {
                        Object number = table.getValueAt(selectedRow, 0);
                        Object text = table.getValueAt(selectedRow, 1);
                        JDialog dialog = new JDialog(frame, "Information");
                        dialog.setSize(new Dimension(200, 150));
                        dialog.setLocationRelativeTo(frame);
                        JOptionPane.showMessageDialog(dialog, "Number: " + number + "\nText: " + text);
                        dialog.setVisible(true);
                    }
                }
            });
            panel.add(button, BorderLayout.SOUTH);
            this.teacher.getMatiere().addObserver(this);
        }

        @Override
        public void update(MyObservable obs, Object obj) {
            System.out.println("aaaaaaaaa");
        }
    }

    public static JPanel QuizzesViewer(Teacher teacher, JFrame frame) {
        ViewQuizzesView view = new ViewQuizzesView(teacher, frame);
        return view.getPanel();
    }
}
