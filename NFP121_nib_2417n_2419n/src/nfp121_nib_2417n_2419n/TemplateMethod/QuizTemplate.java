package nfp121_nib_2417n_2419n.TemplateMethod;

import javax.swing.JPanel;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Teacher.QuizSection;

public abstract class QuizTemplate {

    double maxGrade;
    double questionCorrectGrade;

    public final void createQuiz(Teacher teacher, Quiz quiz) {
        gradeQuiz(quiz);
        calculateGrade(teacher);
    }

    abstract void gradeQuiz(Quiz quiz);

    abstract void calculateGrade(Teacher teacher);
}
