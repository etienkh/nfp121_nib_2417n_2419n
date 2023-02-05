package nfp121_nib_2417n_2419n.Teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.TemplateMethod.QuizTemplate;
import nfp121_nib_2417n_2419n.TemplateMethod.ThreeCreditsCoursesQuiz;


public class TeacherHomePage extends JFrame  {

    public JLabel userLabel;
    public JPanel newPanel1;
    public JPanel newPanel;

    public TeacherHomePage(Teacher teacher) {
        JTabbedPane tabbedPane = new JTabbedPane();
        QuizTemplate quizTemplate;
        tabbedPane.addTab("Course", new CourseSection());
        tabbedPane.addTab("Sessions", new JLabel("This is tab 2"));
        tabbedPane.addTab("View Sessions", new JLabel("This is tab 3"));
        tabbedPane.addTab("Quizes", QuizSection.newQuiz(teacher));
        tabbedPane.addTab("View Quizes", ViewQuizzes.QuizzesViewer(teacher, this));

        this.add(tabbedPane);

        this.setSize(1700, 800);
        this.setLocationRelativeTo(null);

        // set the default close operation and make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

 
}
