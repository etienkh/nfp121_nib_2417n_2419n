package nfp121_nib_2417n_2419n.IHM;

import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;
import static nfp121_nib_2417n_2419n.Singleton.PersonSingleton.getInstance;

import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import nfp121_nib_2417n_2419n.Factory.PersonFactory;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Student.StudentHomePage;
import nfp121_nib_2417n_2419n.Teacher.TeacherHomePage;

class registrationFormIHM extends JFrame {

    // Components of the Form
    private Container c;
    private static JFrame frame;
    private JLabel usernameLab, title;
    private JTextField usernameField, lastNameField, firstNameField;
    private JPasswordField passwordField;
    private JRadioButton student, teacher;
    private ButtonGroup gengp;
    private JLabel passwordLab, firstNameLab, lastNameLab;
    private JButton sub;

    // constructor, to initialize the components
    // with default values.
    registrationFormIHM() {

        frame = new JFrame("Registration");
        frame.setSize(1000, 300);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Create Account");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        c.add(title);

        usernameLab = new JLabel("User Name");
        usernameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLab.setSize(100, 20);
        usernameLab.setLocation(100, 100);
        c.add(usernameLab);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameField.setSize(150, 20);
        usernameField.setLocation(200, 100);
        c.add(usernameField);

        passwordLab = new JLabel("Password");
        passwordLab.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLab.setSize(100, 20);
        passwordLab.setLocation(100, 150);
        c.add(passwordLab);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(150, 20);
        passwordField.setLocation(200, 150);
        c.add(passwordField);

        student = new JRadioButton("Student");
        student.setFont(new Font("Arial", Font.PLAIN, 15));
        student.setSelected(true);
        student.setSize(75, 20);
        student.setLocation(200, 200);
        c.add(student);

        teacher = new JRadioButton("Teacher");
        teacher.setFont(new Font("Arial", Font.PLAIN, 15));
        teacher.setSelected(false);
        teacher.setSize(80, 20);
        teacher.setLocation(275, 200);
        c.add(teacher);

        gengp = new ButtonGroup();
        gengp.add(student);
        gengp.add(teacher);

        firstNameLab = new JLabel("First Name");
        firstNameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        firstNameLab.setSize(150, 20);
        firstNameLab.setLocation(100, 250);
        c.add(firstNameLab);

        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNameField.setSize(150, 20);
        firstNameField.setLocation(200, 250);
        c.add(firstNameField);

        lastNameLab = new JLabel("Last Name");
        lastNameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        lastNameLab.setSize(150, 20);
        lastNameLab.setLocation(100, 300);
        c.add(lastNameLab);

        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameField.setSize(150, 20);
        lastNameField.setLocation(200, 300);
        c.add(lastNameField);

        sub = new JButton("Register");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(200, 350);

        sub.addActionListener(new personFactoryActionListener());

        c.add(sub);

        frame.add(c);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static Frame getFrame() {
        return frame;
    }

    class personFactoryActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String persType = null;

            if (usernameField.getText().trim().isEmpty()) {
                JLabel label = new JLabel("The username can't be empty");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (firstNameField.getText().trim().isEmpty()) {
                JLabel label = new JLabel("The first name can't be empty");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (lastNameField.getText().trim().isEmpty()) {
                JLabel label = new JLabel("The last name can't be empty");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (passwordField.getText().trim().isEmpty()) {
                JLabel label = new JLabel("The password can't be empty");
                label.setFont(new Font("calibri", Font.BOLD, 15));
                JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (student.isSelected()) {
                persType = "student";
            } else if (teacher.isSelected()) {
                persType = "teacher";
            } else {
                assert false;
            }
            try {
                for (Person per : readAllPerson()) {
                    if (per.username.equalsIgnoreCase(usernameField.getText())) {
                        JLabel label = new JLabel("This user name already exist!");
                        label.setFont(new Font("calibri", Font.BOLD, 15));
                        JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                Person person = new Person(usernameField.getText(), firstNameField.getText(), lastNameField.getText(), passwordField.getText());
                Person personRes = PersonFactory.getPerson(person, persType);
                InputOutputPerson.writePerson(personRes);
                Person per = getInstance(personRes);
                if(personRes.getClass() == Teacher.class){
                    new TeacherHomePage((Teacher)per);
                }
                else if(personRes.getClass() == Student.class){
                    new StudentHomePage((Student)per);
                }
          
                registrationFormIHM.getFrame().dispose();
            } catch (Exception ex) {
                Logger.getLogger(registrationFormIHM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
