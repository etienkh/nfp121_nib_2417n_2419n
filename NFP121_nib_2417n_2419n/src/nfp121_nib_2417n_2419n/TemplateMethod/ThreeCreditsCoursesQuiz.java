package nfp121_nib_2417n_2419n.TemplateMethod;

import java.io.Serializable;
import java.util.ArrayList;

import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Teacher;

public class ThreeCreditsCoursesQuiz extends QuizTemplate implements Serializable {

    public void calculateMaxGrade(Teacher teacher) {
        ArrayList<Quiz> quizzes = teacher.getMatiere().getQuizzes();
        super.maxGrade = 100;
        for (Quiz quiz : quizzes) {
            quiz.setMaxGrade(super.maxGrade);
        }
        teacher.getMatiere().setQuizzes(quizzes);
    }

    public void calculateGrade(Teacher teacher) {
        ArrayList<Quiz> quizzes = teacher.getMatiere().getQuizzes();
        int questions = 0;
        for (Quiz quiz : quizzes) {
            questions += quiz.getQuestions().size();
        }
        super.questionCorrectGrade = super.maxGrade / questions;
        for (Quiz quiz : quizzes) {
            quiz.setQuestionGrade(super.questionCorrectGrade);
            quiz.setMaxGrade(super.questionCorrectGrade);
        }
        teacher.getMatiere().setQuizzes(quizzes);
    }
}
