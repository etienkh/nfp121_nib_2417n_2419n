package nfp121_nib_2417n_2419n.Teacher;

import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;

import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nfp121_nib_2417n_2419n.MVC.MyObserver;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.TemplateMethod.ThreeCreditsCoursesQuiz;
import nfp121_nib_2417n_2419n.TemplateMethod.TwoCreditsCoursesQuiz;

/**
 *
 * @author Georges
 */
public class CourseSection extends Container {

    private JLabel nameLab, priceLab, codeLab, creditLab, title;
    private JTextField nameField, priceField, codeField;
    private JRadioButton credit2Radio, credit3Radio;
    private ButtonGroup radioGroup;
    private JButton updateCourseBtn;
    private JTable objectifTab, syllabusTab, chapitreTab;
    private DefaultTableModel objectifModel, syllabusModel, chapitreModel;
    private JScrollPane objectifPane, syllabusPane, chapitrePane, documentScrollPane;
    private JList documentList;
    private DefaultListModel documentModel;
    private JButton addDocumentBtn;
    Teacher teacher;
    Matiere newMatiere;
    ArrayList<Person> personList = readAllPerson();

    public CourseSection(Teacher teacher) {
        this.teacher = teacher;

        title = new JLabel("Course Info");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(100, 30);
        this.add(title);

        nameLab = new JLabel("Name:");
        nameLab.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLab.setSize(100, 20);
        nameLab.setLocation(100, 100);
        this.add(nameLab);

        nameField = new JTextField(15);
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(150, 20);
        nameField.setLocation(160, 100);

        this.add(nameField);

        codeLab = new JLabel("Code:");
        codeLab.setFont(new Font("Arial", Font.PLAIN, 20));
        codeLab.setSize(100, 20);
        codeLab.setLocation(100, 150);
        this.add(codeLab);

        codeField = new JTextField(15);
        codeField.setFont(new Font("Arial", Font.PLAIN, 15));
        codeField.setSize(150, 20);
        codeField.setLocation(160, 150);
        this.add(codeField);

        creditLab = new JLabel("Credit:");
        creditLab.setFont(new Font("Arial", Font.PLAIN, 20));
        creditLab.setSize(100, 20);
        creditLab.setLocation(100, 200);
        this.add(creditLab);

        credit2Radio = new JRadioButton("2");
        credit2Radio.setFont(new Font("Arial", Font.PLAIN, 15));
        credit2Radio.setSize(50, 20);
        credit2Radio.setLocation(160, 200);
        this.add(credit2Radio);

        credit3Radio = new JRadioButton("3");
        credit3Radio.setFont(new Font("Arial", Font.PLAIN, 15));
        credit3Radio.setSize(50, 20);
        credit3Radio.setLocation(220, 200);
        if (teacher.getMatiere() != null) {
            if (teacher.getMatiere().getCredit() == 3) {
                credit3Radio.setSelected(true);
            } else {
                credit3Radio.setSelected(true);
            }
        }
        this.add(credit3Radio);

        radioGroup = new ButtonGroup();
        radioGroup.add(credit2Radio);
        radioGroup.add(credit3Radio);

        priceLab = new JLabel("Price:");
        priceLab.setFont(new Font("Arial", Font.PLAIN, 20));
        priceLab.setSize(100, 20);
        priceLab.setLocation(100, 250);
        this.add(priceLab);

        priceField = new JTextField(15);
        priceField.setFont(new Font("Arial", Font.PLAIN, 15));
        priceField.setSize(150, 20);
        priceField.setLocation(160, 250);
        priceField.setEnabled(false);
        this.add(priceField);

        if (teacher.getMatiere() != null) {
            nameField.setText(teacher.getMatiere().getName());
            codeField.setText(teacher.getMatiere().getCode());
            priceField.setText(Integer.toString(teacher.getMatiere().getPrice()));
        }

        updateCourseBtn = new JButton("Update Course");
        updateCourseBtn.setFont(new Font("Arial", Font.PLAIN, 15));
        updateCourseBtn.setSize(150, 20);
        updateCourseBtn.setLocation(160, 300);
        updateCourseBtn.addActionListener(new updateCourseActionListener());
        this.add(updateCourseBtn);

        String[] columnObjectif = { "Objectif" };
        String objectifData[][] = new String[11][1];
        if (teacher.getMatiere() != null) {
            ;
            for (int i = 0; i < objectifData.length && i < teacher.getMatiere().getObjectifs().size(); i++) {

                objectifData[i][0] = teacher.getMatiere().getObjectifs().get(i);
            }
        }

        objectifModel = new DefaultTableModel(objectifData, columnObjectif);
        objectifTab = new JTable(objectifModel);
        objectifPane = new JScrollPane(objectifTab);
        objectifPane.setBounds(350, 100, 300, 200);

        objectifPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    objectifModel.addRow(new Object[] { "" });
                }
            }

        });
        this.add(objectifPane);

        String[] columnSyllabus = { "syllabus" };
        String syllabusData[][] = new String[11][1];
        if (teacher.getMatiere() != null) {
            ;
            for (int i = 0; i < syllabusData.length && i < teacher.getMatiere().getSyllabus().size(); i++) {

                syllabusData[i][0] = teacher.getMatiere().getSyllabus().get(i);
            }
        }
        syllabusModel = new DefaultTableModel(syllabusData, columnSyllabus);
        syllabusTab = new JTable(syllabusModel);
        syllabusPane = new JScrollPane(syllabusTab);

        syllabusPane.setBounds(
                660, 100, 300, 200);

        syllabusPane.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    syllabusModel.addRow(new Object[] { "" });
                }
            }

        });
        this.add(syllabusPane);

        String[] columnChapitre = { "chapitre" };

        String chapitreData[][] = new String[11][1];
        if (teacher.getMatiere() != null) {
            ;
            for (int i = 0; i < chapitreData.length && i < teacher.getMatiere().getChapitres().size(); i++) {

                chapitreData[i][0] = teacher.getMatiere().getChapitres().get(i);
            }
        }
        chapitreModel = new DefaultTableModel(chapitreData, columnChapitre);
        chapitreTab = new JTable(chapitreModel);
        chapitrePane = new JScrollPane(chapitreTab);
        chapitrePane.setBounds(970, 100, 300, 200);

        chapitrePane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    chapitreModel.addRow(new Object[] { "" });
                }
            }

        });
        this.add(chapitrePane);

        documentModel = new DefaultListModel<File>();

        if (teacher.getMatiere() != null) {
            for (int i = 0; i < this.teacher.getMatiere().getDocuments().size(); i++) {
                documentModel.addElement(teacher.getMatiere().getDocuments().get(i));
            }
        }
        documentList = new JList<File>(documentModel);

        documentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    File selectedFile = (File) documentList.getSelectedValue();
                    if (selectedFile != null) {
                        try {
                            Desktop.getDesktop().open(selectedFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        documentScrollPane = new JScrollPane(documentList);
        documentScrollPane.setBounds(1300, 100, 300, 200);
        documentScrollPane.setBorder(BorderFactory.createTitledBorder("Documents"));

        this.add(documentScrollPane);

        addDocumentBtn = new JButton("Add Document");
        addDocumentBtn.setSize(150, 20);
        addDocumentBtn.setLocation(1390, 300);

        addDocumentBtn.addActionListener(new AddDocumentListener());
        this.add(addDocumentBtn);

    }

    class updateCourseActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            try {
                if (chapitreTab.getCellEditor() != null) {
                    chapitreTab.getCellEditor().stopCellEditing();
                }
                if (syllabusTab.getCellEditor() != null) {
                    syllabusTab.getCellEditor().stopCellEditing();
                }
                if (objectifTab.getCellEditor() != null) {
                    objectifTab.getCellEditor().stopCellEditing();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String name = nameField.getText();

            int credit = 2;
            if (credit3Radio.isSelected()) {
                credit = 3;
            }
            String code = codeField.getText();

            newMatiere = new Matiere(code, name, credit);
            for (MyObserver obs : teacher.getMatiere().getObservers()) {
                newMatiere.addObserver(obs);
            }
            if (teacher.getMatiere() != null && teacher.getMatiere().getQuizzes().size() > 0) {
                newMatiere.setQuizzes(teacher.getMatiere().getQuizzes());
            }
            switch (credit) {
                case 2:
                    newMatiere.setQuizTemplate(new TwoCreditsCoursesQuiz());
                    break;
                case 3:
                    newMatiere.setQuizTemplate(new ThreeCreditsCoursesQuiz());
                    break;
            }
            teacher.setMatiere(newMatiere);
            for (int row = 0; row < objectifTab.getRowCount(); row++) {
                teacher.getMatiere().getObjectifs().add((String) objectifTab.getValueAt(row, 0));
            }
            for (int row = 0; row < syllabusTab.getRowCount(); row++) {
                teacher.getMatiere().getSyllabus().add((String) syllabusTab.getValueAt(row, 0));
            }
            for (int row = 0; row < chapitreTab.getRowCount(); row++) {
                teacher.getMatiere().getChapitres().add((String) chapitreTab.getValueAt(row, 0));
            }
            for (int row = 0; row < documentModel.getSize(); row++) {
                teacher.getMatiere().getDocuments().add((File) documentModel.getElementAt(row));
            }

            if (teacher.getMatiere().getQuizzes().size() > 0) {
                teacher.getMatiere().getQuizTemplate().GradeQuiz(teacher);
            }

            for (int i = 0; i < personList.size(); i++) {
                if (teacher.username.equalsIgnoreCase(personList.get(i).username)) {
                    personList.set(i, teacher);
                }
                priceField.setText(Integer.toString(teacher.getMatiere().getPrice()));
            }
            try {

                File output = new File("person");
                FileOutputStream fos = new FileOutputStream(output);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(personList);
                oos.flush();
                oos.close();
                readAllPerson();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    class AddDocumentListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) // pass action listener as a parameter
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File selectedFile = fileChooser.getSelectedFile();
            documentModel.addElement(selectedFile);

        }

    }

}
