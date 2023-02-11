package nfp121_nib_2417n_2419n.Student;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Teacher.SessionsSection;

public class StudentHomePage extends JFrame {

    public StudentHomePage(Student student) {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inscription", new InscriptionSection(student));
        tabbedPane.addTab("Payement", new PayementSection(student));
        tabbedPane.addTab("View Courses", new ViewCourse(student));
        tabbedPane.addTab("Profile", new StudentProfile(student));
        tabbedPane.addTab("View Sessions", SessionsSectionsStud.getSessionsSection(student, this));
        tabbedPane.addTab("Note", new Note(student));
//        tabbedPane.addTab("View Quizes", ViewQuizzes.QuizzesViewer(teacher, this));

        this.add(tabbedPane);

        this.setSize(1700, 800);
        this.setLocationRelativeTo(null);

        // set the default close operation and make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
//      public static void main(String[] args) {
//        new StudentHomePage(students);
//    }

}
