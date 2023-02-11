package nfp121_nib_2417n_2419n.Student;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import nfp121_nib_2417n_2419n.Model.Student;

public class StudentHomePage extends JFrame {

    public StudentHomePage(Student student) {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Inscription", new InscriptionSection(student));
        tabbedPane.addTab("Payement", new PayementSection(student));
        tabbedPane.addTab("Profile", new StudentProfile(student));
        tabbedPane.addTab("Quizzes", DisplayQuizzes.QuizzesViewer(student, this));

        this.add(tabbedPane);

        this.setSize(1700, 800);
        this.setLocationRelativeTo(null);

        // set the default close operation and make the frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    // public static void main(String[] args) {
    // new StudentHomePage(students);
    // }

}
