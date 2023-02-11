package nfp121_nib_2417n_2419n.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import nfp121_nib_2417n_2419n.Command.Command;
import nfp121_nib_2417n_2419n.Command.EvaluateQuizCommand;
import nfp121_nib_2417n_2419n.Command.invoker;
import nfp121_nib_2417n_2419n.Model.Answers;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Question;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.TemplateMethod.QuizTemplate;

public class StartQuizDialog extends JDialog {

    private JLabel questionLabel;
    private JButton finishBtn;
    private Student student;
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private QuizTemplate template;
    public QuizTemplate getTemplate() {
        return template;
    }

    public void setTemplate(QuizTemplate template) {
        this.template = template;
    }

    private ArrayList<Answers> resultat;
    public ArrayList<Answers> getResultat() {
        return resultat;
    }

    public void setResultat(ArrayList<Answers> resultat) {
        this.resultat = resultat;
    }

    private Matiere matiere;
    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public JButton getFinishBtn() {
        return finishBtn;
    }

    public void setFinishBtn(JButton finishBtn) {
        this.finishBtn = finishBtn;
    }

    public StartQuizDialog(JFrame parent, Student student, QuizTemplate template, ArrayList<Answers> resultats, Matiere matiere, Quiz quiz){
        
        super(parent, "Quiz", true);
        this.student = student;
        this.template = template;
        this.resultat = new ArrayList<Answers>();
        this.matiere = matiere;
        this.quiz = quiz;
        for(Question question : quiz.getQuestions()){
            JPanel panel = generateQuestion(question);
            add(panel);
        }
        
        finishBtn = new JButton("Finish");
        finishBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command command = new EvaluateQuizCommand(parent, student, template, resultat, matiere, quiz);
                invoker invoker = new invoker(command);
                dispose();
              try {
                  invoker.execute();
              } catch (IOException e1) {
                  e1.printStackTrace();
              }
            }
          });
        setLayout(new FlowLayout());
        add(questionLabel);
        add(finishBtn);

        setSize(1000 , 1000);
        setResizable(true);
        setLocationRelativeTo(parent);
    }

    public JPanel generateQuestion(Question question) {
        this.resultat.add(new Answers(question, ""));
        ButtonGroup answerButtonGroup;

        JPanel panel = new JPanel();
        questionLabel = new JLabel(question.getQuestion());
        panel.add(questionLabel, BorderLayout.NORTH);

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(4, 1));
        answerButtonGroup = new ButtonGroup();
        for(String choice : question.getChoices()){
            JRadioButton answer1RadioButton = new JRadioButton(choice);
            answerButtonGroup.add(answer1RadioButton);
            answerPanel.add(answer1RadioButton);
            answer1RadioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for(int i = 0 ; i< resultat.size() ; i++){
                        if(resultat.get(i).getQuestion().getQuestion().equalsIgnoreCase(question.getQuestion())){
                            resultat.remove(i);
                            break;
                        }
                    }
                    resultat.add(new Answers(question, answer1RadioButton.getText()));
                }
            });
        }
        panel.add(answerPanel, BorderLayout.CENTER);
        return panel;
    }
}
