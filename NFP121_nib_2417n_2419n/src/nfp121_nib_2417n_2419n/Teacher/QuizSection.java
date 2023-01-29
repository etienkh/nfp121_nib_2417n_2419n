package nfp121_nib_2417n_2419n.Teacher;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizSection extends JPanel {

    // GUI components
    private JLabel questionLabel;
    private JTextField questionField;
    private JLabel answerLabel;
    private JTextField[] answerFields;
    private JLabel correctAnswerLabel;
    private JComboBox correctAnswerComboBox;
    private JButton submitButton;

    public QuizSection() {
        // Initialize GUI components
        questionLabel = new JLabel("Question:");
        questionField = new JTextField(20);
        answerLabel = new JLabel("Answers:");
        answerFields = new JTextField[4];
        correctAnswerLabel = new JLabel("Correct Answer:");
        String[] answers = new String[4];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = "Answer " + (i + 1);
            answerFields[i] = new JTextField(20);
        }
        correctAnswerComboBox = new JComboBox(answers);
        submitButton = new JButton("Submit Quiz");

        // Add action listener to submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String question = questionField.getText();
                String[] answers = new String[4];
                for (int i = 0; i < answerFields.length; i++) {
                    answers[i] = answerFields[i].getText();
                }
                int correctAnswer = correctAnswerComboBox.getSelectedIndex();
                createQuiz(question, answers, correctAnswer);
            }
        });

        // Add components to form
        add(questionLabel);
        add(questionField);
        add(answerLabel);
        for (JTextField answerField : answerFields) {
            add(answerField);
        }
        add(correctAnswerLabel);
        add(correctAnswerComboBox);
        add(submitButton);

        // Set form layout and properties
        setVisible(true);
    }

    private void createQuiz(String question, String[] answers, int correctAnswer) {
        System.out.println("Question: " + question);
        System.out.println("Answers: " + Arrays.toString(answers));
        System.out.println("Correct Answer: " + (correctAnswer + 1));
    }
}
