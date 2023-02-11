package nfp121_nib_2417n_2419n.Command;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import nfp121_nib_2417n_2419n.IHM.InputOutputPerson;
import nfp121_nib_2417n_2419n.Model.Answers;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Quiz;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Student.StartQuizDialog;
import nfp121_nib_2417n_2419n.TemplateMethod.QuizTemplate;

public class StartQuizCommand implements Command {
    private Quiz quiz;
    private Student student;
    private JFrame frame;
    private QuizTemplate template;
    private Matiere matiere;
    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    private ArrayList<Answers> resultat;

    public ArrayList<Answers> getResultat() {
        return resultat;
    }

    public void setResultat(ArrayList<Answers> resultat) {
        this.resultat = resultat;
    }

    public QuizTemplate getTemplate() {
        return template;
    }

    public void setTemplate(QuizTemplate template) {
        this.template = template;
    }

    public StartQuizCommand(JFrame parent, Student student, QuizTemplate template, ArrayList<Answers> resultat, Matiere matiere, Quiz quiz){
        this.template = template;
        this.resultat = resultat;
        this.matiere = matiere;
        this.quiz = quiz;
        this.student = student;
        this.frame = parent;
    }

    @Override
    public void execute() throws FileNotFoundException, IOException {
        ArrayList<Person> persons = InputOutputPerson.readAllPerson();
        ArrayList<Person> students = quiz.getStudents();
        students.add(student);
        quiz.setStudents(students);
        InputOutputPerson.updatePerson(student);
        for(int i = 0 ; i < persons.size(); i++){
            if(persons.get(i).getClass() == Teacher.class){
                Teacher t = (Teacher) persons.get(i);
                if(t.getMatiere().getCode() == matiere.getCode()){
                    Matiere m = t.getMatiere();
                    ArrayList<Quiz> q = m.getQuizzes();
                    for(int j = 0 ; j < q.size() ; i++){
                        if(q.get(j).getQuizTitle() == quiz.getQuizTitle()){
                            q.get(j).setStudents(students);    
                            m.setQuizzes(q);
                            t.setMatiere(m);    
                        }
                    }
                }    
                InputOutputPerson.updatePerson(t);
            }
        }
        JDialog dialog = new StartQuizDialog(frame, student, template, resultat, matiere, quiz);
        dialog.setVisible(true);
    }


}
