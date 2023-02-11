package nfp121_nib_2417n_2419n.TemplateMethod;

import nfp121_nib_2417n_2419n.Model.Teacher;

public abstract class QuizTemplate {

    public double maxGrade;
    public double getMaxGrade() {
        return maxGrade;
    }

    public void setMaxGrade(double maxGrade) {
        this.maxGrade = maxGrade;
    }

    public double questionCorrectGrade;

    public double getQuestionCorrectGrade() {
        return questionCorrectGrade;
    }

    public void setQuestionCorrectGrade(double questionCorrectGrade) {
        this.questionCorrectGrade = questionCorrectGrade;
    }

    public final void GradeQuiz(Teacher teacher) {
        calculateMaxGrade(teacher);
        calculateGrade(teacher);
    }

    abstract void calculateMaxGrade(Teacher teacher);

    abstract void calculateGrade(Teacher teacher);
}
