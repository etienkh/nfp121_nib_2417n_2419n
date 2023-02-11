package nfp121_nib_2417n_2419n.Command;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.Model.Answers;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Resultat;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.TemplateMethod.QuizTemplate;

public class EvaluateQuizCommand implements Command {

    private Student student; 
    private QuizTemplate quizTemplate; 
    private ArrayList<Answers> answers;
    private Matiere matiere;
    private Quiz quiz;
    private JFrame frame;
    
    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public EvaluateQuizCommand(JFrame frame, Student student, QuizTemplate template, ArrayList<Answers> resultat, Matiere matiere, Quiz quiz){
        this.frame = frame;
        this.answers = resultat;
        this.student = student;
        this.quizTemplate = template;
        this.matiere = matiere;
        this.quiz = quiz;
    }

    @Override
    public void execute() throws FileNotFoundException, IOException {
        double note = 0.0;
        double maxNote = 0.0;
        for(Answers answer :  answers){
            if(answer.getAnswer().equalsIgnoreCase(answer.getQuestion().getAnswer())){
                note += quiz.getQuestionGrade();
            }
            maxNote += quiz.getQuestionGrade();
        }
        ArrayList<Resultat> resultats = student.getResultats();
        Resultat res = new Resultat(matiere.getCode(), note, quiz.getQuizTitle(), maxNote);
        resultats.add(res);
        student.setResultats(resultats);
        InputOutputPerson.updatePerson(student);
        JDialog dialog = new JDialog(frame, "Information");
        dialog.setSize(new Dimension(200, 150));
        dialog.setLocationRelativeTo(frame);
        JOptionPane.showMessageDialog(dialog,
                "You got " +res.getNote() +" over " +res.getMaxNote());
    }
    
}
