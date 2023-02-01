abstract class QuizTemplate {
   final void createQuiz() {
       gradeQuiz();
       displayResults();
   }
   abstract void gradeQuiz();
   abstract void displayResults();
}

class TwoCreditsCoursesQuiz extends QuizTemplate {
   void gradeQuiz() {
       // code to grade English quiz
   }
   void displayResults() {
       // code to display English quiz results
   }
}

class ThreeCreditsCoursesQuiz extends QuizTemplate {
   void gradeQuiz() {
       // code to grade Math quiz
   }
   void displayResults() {
       // code to display Math quiz results
   }
}
