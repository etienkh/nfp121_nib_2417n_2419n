package nfp121_nib_2417n_2419n.Student;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nfp121_nib_2417n_2419n.Command.Command;
import nfp121_nib_2417n_2419n.Command.StartQuizCommand;
import nfp121_nib_2417n_2419n.Command.invoker;
import nfp121_nib_2417n_2419n.Model.Answers;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Resultat;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.TemplateMethod.QuizTemplate;

public class DisplayQuizzes {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private JPanel panel;
    private DefaultTableModel model;
    private JTable table;
    ArrayList<QuizMatiereDTO> quizMatiereDTO;

    public JPanel getPanel() {
        return panel;
    }

    DisplayQuizzes(Student student, JFrame frame) {
        this.student = student;

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String[] columns = { "Code Matiere", "Quiz Name" };
        Object[][] data;
        if (student.getMatieres().size() > 0) {
            quizMatiereDTO = new ArrayList<QuizMatiereDTO>();
            for (Matiere matiere : student.getMatieres()) {
                for (Quiz quiz : matiere.getQuizzes()) {
                    if (quiz.getStudents().size() > 0) {
                        for (Person person : quiz.getStudents()) {
                            if (!person.username.equalsIgnoreCase(student.username)) {
                                quizMatiereDTO.add(new QuizMatiereDTO(matiere, quiz));
                            }
                        }
                    } else {
                        quizMatiereDTO.add(new QuizMatiereDTO(matiere, quiz));
                    }
                }
            }
            data = new Object[quizMatiereDTO.size()][2];
            for (int i = 0; i < quizMatiereDTO.size(); i++) {
                data[i][0] = quizMatiereDTO.get(i).matiere.getCode();
                data[i][1] = quizMatiereDTO.get(i).quiz.getQuizTitle();
            }
        } else {
            data = new Object[0][0];
        }

        model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton button = new JButton("Take Quiz");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "Please select a row.");
                } else if (student.getMatieres().size() > 0) {
                    QuizDialog dialog = new QuizDialog(frame, student,
                            quizMatiereDTO.get(selectedRow).matiere.getQuizTemplate(),
                            quizMatiereDTO.get(selectedRow).matiere, quizMatiereDTO.get(selectedRow).quiz);
                    dialog.setVisible(true);
                }
            }
        });
        panel.add(button, BorderLayout.SOUTH);
    }

    public static JPanel QuizzesViewer(Student student, JFrame frame) {
        DisplayQuizzes view = new DisplayQuizzes(student, frame);
        return view.getPanel();
    }

    public class QuizMatiereDTO {
        Matiere matiere;
        Quiz quiz;

        public QuizMatiereDTO(Matiere matiere, Quiz quiz) {
            this.matiere = matiere;
            this.quiz = quiz;
        }

        @Override
        public String toString() {
            return "QuizMatiereDTO [matiere=" + matiere + ", quiz=" + quiz + "]";
        }

    }

    public class QuizDialog extends JDialog {

        private JLabel questionLabel;
        private JButton startQuizButton;
        private QuizTemplate template;

        public QuizTemplate getTemplate() {
            return template;
        }

        public void setTemplate(QuizTemplate template) {
            this.template = template;
        }

        private ArrayList<Answers> resultat;

        public ArrayList<Answers> getResultat() {
            return resultat;
        }

        public void setResultat(ArrayList<Answers> resultat) {
            this.resultat = resultat;
        }

        private Matiere matiere;

        public Matiere getMatiere() {
            return matiere;
        }

        public void setMatiere(Matiere matiere) {
            this.matiere = matiere;
        }

        private Quiz quiz;

        public Quiz getQuiz() {
            return quiz;
        }

        public void setQuiz(Quiz quiz) {
            this.quiz = quiz;
        }

        public QuizDialog(JFrame parent, Student student, QuizTemplate template,
                Matiere matiere, Quiz quiz) {
            super(parent, "Start Quiz", true);
            this.template = template;
            this.resultat = new ArrayList<Answers>();
            this.matiere = matiere;
            this.quiz = quiz;

            questionLabel = new JLabel("Do you want to start the quiz?");
            startQuizButton = new JButton("Start");
            Command command = new StartQuizCommand(parent, student, template, resultat, matiere, quiz);
            startQuizButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    invoker invoker = new invoker(command);
                    try {
                        dispose();
                        invoker.execute();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });

            setLayout(new FlowLayout());
            add(questionLabel);
            add(startQuizButton);

            setSize(300, 100);
            setResizable(false);
            setLocationRelativeTo(parent);
        }
    }

}
