package nfp121_nib_2417n_2419n.Teacher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.MVC.MyObservable;
import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Question;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Teacher;

class QuizView extends JFrame implements MyObserver {

    private JLabel correctChoiceLabel;
    private JTextField correctChoiceField;
    private JTextArea resultArea;
    private JPanel panel;

    private Quiz quiz;
    private Question question;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public QuizView(Quiz quiz, Question question) {
        setTitle("Quiz Creator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        correctChoiceLabel = new JLabel("Quiz Title : ");
        correctChoiceField = new JTextField(100);
        correctChoiceField.getDocument().addDocumentListener(new TextFieldListener());

        this.resultArea = new JTextArea(30, 60);
        this.resultArea.setEditable(false);

        this.panel = new JPanel();

        this.panel.add(correctChoiceLabel);
        this.panel.add(correctChoiceField);

        this.panel.add(this.resultArea);

        this.quiz = quiz;
        this.question = question;
        this.quiz.addObserver(this);
        this.question.addObserver(this);
    }

    public void updateChoices() {
        resultArea.setText("");
        int count = 1;
        for (String choice : question.getChoices()) {
            resultArea.append(count + ". " + choice + "\n");
            count++;
        }
    }

    public void showResult(String result) {
        resultArea.setText(result);
    }

    public JPanel getMainPanel() {
        return panel;
    }

    @Override
    public void update(MyObservable obs, Object obj) {
        if (obs.getClass() == Question.class) {
            updateChoices();
        } else {
            showResult(quiz.toString());
            if (!quiz.isValid()) {
                resultArea.setText("");
                correctChoiceField.setText("");
            }
        }
    }

    private class TextFieldListener implements DocumentListener {

        public void insertUpdate(DocumentEvent e) {
            try {
                String title = e.getDocument().getText(0, e.getDocument().getLength());
                quiz.setQuizTitle(title);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        public void removeUpdate(DocumentEvent e) {
            try {
                String title = e.getDocument().getText(0, e.getDocument().getLength());
                quiz.setQuizTitle(title);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }

        public void changedUpdate(DocumentEvent e) {
            // not applicable for plain text fields
        }
    }
}

// Controller
class QuizController {

    private Quiz quiz;
    private Question question;
    private Teacher teacher;
    private List<String> choices;
    private List<JTextField> choiceFields = new ArrayList<>();
    JPanel panel;
    JTextField questionField, choiceField, correctChoiceField;
    private JButton newQuizBtn, addChoiceBtn, resetBtn, finishBtn, addQuestionBtn;

    public QuizController(Quiz quiz, Question question, Teacher teacher) {
        this.quiz = quiz;
        this.question = question;
        this.teacher = teacher;

        choices = new ArrayList<>();

        panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        addChoiceBtn = getAddChoiceButton();
        resetBtn = getResetButton();
        finishBtn = getFinishButton();
        addQuestionBtn = getAddQuestionButton();

        questionField = getQuestionField();
        choiceField = getChoiceField();
        correctChoiceField = getCorrectChoiceField();

        newQuizBtn = new JButton("Create New Quiz");
        newQuizBtn.addActionListener(new NewQuizListener());

        panel1.add(getQuestionLabel());
        panel1.add(questionField);
        panel2.add(getAddChoiceLabel());
        panel2.add(choiceField);
        panel2.add(addChoiceBtn);
        panel3.add(getCorrectChoiceLabel());
        panel3.add(correctChoiceField);
        panel4.add(addQuestionBtn);
        panel4.add(resetBtn);
        panel4.add(finishBtn);
        panel4.add(newQuizBtn);
        newQuizBtn.setVisible(false);
        addChoiceBtn.addActionListener(new AddChoiceListener());
        addQuestionBtn.addActionListener(new AddQuestionListener());
        resetBtn.addActionListener(new ResetListener());
        finishBtn.addActionListener(new FinishListener());
        panel.setLayout(new BorderLayout());
        panel.add(panel1, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.EAST);
        panel.add(panel3, BorderLayout.WEST);
        panel.add(panel4, BorderLayout.SOUTH);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JButton getAddChoiceButton() {
        JButton addChoiceButton = new JButton("Add Choice");
        return addChoiceButton;
    }

    public JLabel getAddChoiceLabel() {
        JLabel questionLabel = new JLabel("Choice: ");
        return questionLabel;
    }

    public JButton getAddQuestionButton() {
        JButton addQuestionButton = new JButton("Add Question");
        return addQuestionButton;
    }

    public JLabel getQuestionLabel() {
        JLabel choiceLabel = new JLabel("Question: ");
        return choiceLabel;
    }

    public JButton getResetButton() {
        JButton resetButton = new JButton("Reset");
        return resetButton;
    }

    public JLabel getCorrectChoiceLabel() {
        JLabel correctChoiceLabel = new JLabel("Correct Choice: ");
        return correctChoiceLabel;
    }

    public JButton getFinishButton() {
        JButton finishButton = new JButton("Finish");
        return finishButton;
    }

    public JTextField getQuestionField() {
        JTextField questionField = new JTextField(80);
        return questionField;
    }

    public JTextField getChoiceField() {
        JTextField choiceField = new JTextField(50);
        return choiceField;
    }

    public JTextField getCorrectChoiceField() {
        JTextField correctChoiceField = new JTextField(50);
        return correctChoiceField;
    }

    public void addChoiceField(JTextField choiceField) {
        choiceFields.add(choiceField);
    }

    public void clearChoices() {
        choiceFields.clear();
    }

    private class AddChoiceListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String choice = choiceField.getText();
            choices.add(choice);
            clearChoices();
            choiceField.setText("");
            JTextField choiceField = new JTextField(20);
            addChoiceField(choiceField);
            question.setOptions(choices);
        }
    }

    private class AddQuestionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String questionTitle = questionField.getText();
            question.setQuestion(questionTitle);
            question.setOptions(choices);
            question.setAnswer(correctChoiceField.getText());
            questionField.setText("");
            correctChoiceField.setText("");
            choices = new ArrayList<>();
            clearChoices();
            Question clone = new Question(question.getQuestion(), question.getChoices(), question.getCorrectChoice());
            quiz.addQuestion(clone);
        }
    }

    private class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            questionField.setText("");
            correctChoiceField.setText("");
            clearChoices();
            quiz.clear();
            choices.clear();
        }
    }

    private class FinishListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (quiz.isValid()) {
                finishBtn.setEnabled(false);
                addQuestionBtn.setEnabled(false);
                resetBtn.setEnabled(false);
                addChoiceBtn.setEnabled(false);
                newQuizBtn.setVisible(true);
                ArrayList<Quiz> quizzes = teacher.getMatiere().getQuizzes();
                ArrayList<Question> cloneQuestions = new ArrayList<Question>();
                for(Question question : quiz.getQuestions()){
                    Question cloneQuestion = new Question(question.getQuestion(), question.getOptions(), question.getAnswer());
                    cloneQuestions.add(cloneQuestion);
                }
                Quiz clone = new Quiz(quiz.getQuizTitle(), cloneQuestions);
                quizzes.add(clone);
                teacher.getMatiere().setQuizzes(quizzes);
                teacher.getMatiere().getQuizTemplate().GradeQuiz(teacher);
                try {
                    InputOutputPerson.updatePerson(teacher);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private class NewQuizListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            quiz.clear();
            finishBtn.setEnabled(true);
            addQuestionBtn.setEnabled(true);
            resetBtn.setEnabled(true);
            addChoiceBtn.setEnabled(true);
            newQuizBtn.setVisible(false);
            questionField.setText("");
            choiceField.setText("");
            correctChoiceField.setText("");
        }
    }
}

public class QuizSection {

    public static JPanel newQuiz(Teacher teacher) {
        Quiz quiz = new Quiz();
        Question question = new Question();
        QuizView quizView = new QuizView(quiz, question);
        QuizController quizController = new QuizController(quiz, question, teacher);

        quizView.getMainPanel().add(quizController.getPanel());

        return quizView.getMainPanel();
    }

}
