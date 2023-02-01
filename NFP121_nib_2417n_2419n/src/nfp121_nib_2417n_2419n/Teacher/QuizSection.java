package nfp121_nib_2417n_2419n.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import nfp121_nib_2417n_2419n.Model.Question;
import nfp121_nib_2417n_2419n.Model.Quiz;

class QuizView extends JFrame {

    private JLabel questionLabel;
    private JTextField questionField;
    private JLabel choiceLabel;
    private JTextField choiceField;
    private JLabel correctChoiceLabel;
    private JTextField correctChoiceField;
    private JButton addChoiceButton;
    private JButton addQuestionButton;
    private JButton resetButton;
    private JButton finishButton;
    private JTextArea resultArea;
    private JPanel panel, panel1, panel2, panel3, panel4, panel5;
    private List<JTextField> choiceFields = new ArrayList<>();

    public QuizView() {
        setTitle("Quiz Creator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        questionLabel = new JLabel("Question: ");
        questionField = new JTextField(80);
        choiceLabel = new JLabel("Choice: ");
        choiceField = new JTextField(50);
        correctChoiceLabel = new JLabel("Correct Choice: ");
        correctChoiceField = new JTextField(50);
        addChoiceButton = new JButton("Add Choice");
        addQuestionButton = new JButton("Add Question");
        resetButton = new JButton("Reset");
        finishButton = new JButton("Finish");
        resultArea = new JTextArea(30, 60);
        resultArea.setEditable(false);

        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();

        panel1.add(questionLabel);
        panel1.add(questionField);
        panel2.add(choiceLabel);
        panel2.add(choiceField);
        panel2.add(addChoiceButton);
        panel3.add(correctChoiceLabel);
        panel3.add(correctChoiceField);
        panel4.add(addQuestionButton);
        panel4.add(resetButton);
        panel4.add(finishButton);
        panel5.add(resultArea);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);

        add(panel);
    }

    public JButton getAddChoiceButton() {
        return addChoiceButton;
    }

    public JButton getAddQuestionButton() {
        return addQuestionButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getFinishButton() {
        return finishButton;
    }

    public JTextField getQuestionField() {
        return questionField;
    }

    public JTextField getChoiceField() {
        return choiceField;
    }

    public JTextField getCorrectChoiceField() {
        return correctChoiceField;
    }

    public JTextArea getResultArea() {
        return resultArea;
    }

    public void addChoiceField(JTextField choiceField) {
        choiceFields.add(choiceField);
    }

    public void clearChoices() {
        choiceFields.clear();
    }

    public void updateChoices(List<String> choices) {
        resultArea.setText("");
        int count = 1;
        for (String choice : choices) {
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
}

// Controller
class QuizController {

    private Quiz quiz;
    private QuizView quizView;
    private List<String> choices;

    public QuizController(Quiz quiz, QuizView quizView) {
        this.quiz = quiz;
        this.quizView = quizView;
        choices = new ArrayList<>();

        quizView.getAddChoiceButton().addActionListener(new AddChoiceListener());
        quizView.getAddQuestionButton().addActionListener(new AddQuestionListener());
        quizView.getResetButton().addActionListener(new ResetListener());
        quizView.getFinishButton().addActionListener(new FinishListener());
    }

    private class AddChoiceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = quizView.getChoiceField().getText();
            choices.add(choice);
            quizView.clearChoices();
            quizView.updateChoices(choices);
            quizView.getChoiceField().setText("");
            JTextField choiceField = new JTextField(20);
            quizView.addChoiceField(choiceField);
        }
    }

    private class AddQuestionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String question = quizView.getQuestionField().getText();
            quiz.addQuestion(new Question(question, choices, quizView.getCorrectChoiceField().getText()));
            quizView.getQuestionField().setText("");
            quizView.getCorrectChoiceField().setText("");
            choices = new ArrayList<>();
            quizView.clearChoices();
        }
    }

    private class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            quizView.getQuestionField().setText("");
            quizView.getCorrectChoiceField().setText("");
            quizView.clearChoices();
            quiz.clear();
            choices.clear();
        }
    }

    private class FinishListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            quizView.showResult(quiz.toString());
        }
    }
}

public class QuizSection {

    public static JPanel newQuiz() {
        Quiz quiz = new Quiz();
        QuizView quizView = new QuizView();
        QuizController quizController = new QuizController(quiz, quizView);

        return quizView.getMainPanel();

    }
}
