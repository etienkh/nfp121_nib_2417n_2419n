package nfp121_nib_2417n_2419n.TemplateMethod;

import nfp121_nib_2417n_2419n.Model.Teacher;

public abstract class QuizTemplate {

    double maxGrade;
    double questionCorrectGrade;

    public final void GradeQuiz(Teacher teacher) {
        calculateMaxGrade(teacher);
        calculateGrade(teacher);
    }

    abstract void calculateMaxGrade(Teacher teacher);

    abstract void calculateGrade(Teacher teacher);
}
