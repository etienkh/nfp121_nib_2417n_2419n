package nfp121_nib_2417n_2419n.TemplateMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import nfp121_nib_2417n_2419n.Model.Question;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Teacher.QuizSection;

public class TwoCreditsCoursesQuiz extends QuizTemplate {

    public void gradeQuiz(Quiz quiz) {
        super.maxGrade = 80;
    }

    public void calculateGrade(Teacher teacher) {
        ArrayList<Quiz> quizzes = teacher.getMatiere().getQuizzes();
        int questions = 0;
        for(Quiz quiz: quizzes){
            questions += quiz.getQuestions().size();
        }
        super.questionCorrectGrade = super.maxGrade/questions;
    }
}
