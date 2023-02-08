/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.ChaineOfResponsability;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Student;

/**
 *
 * @author Georges
 */
public class InscriptionInformation extends PayementHandler {

    static Student student;
    private String data[][];
    private JFrame frame;
    private DefaultTableModel matiereModel;
    private JTable matiereTab;
    private JScrollPane matiereScroll;
    private JButton payementBtn;
    static int priceTot ;
    private JPanel panel;
    private int k ;
    private PayementHandler next;

    public InscriptionInformation(Student student) {
        this.student = student;
        priceTot = 0;
        k = 0;
        frame = new JFrame();
        data = new String[student.getMatiereIns().size() + 1][6];
        String column[] = {"Code", "Nom matiere", "Credit", "Prix", "Prix Total"};

        for (int i = 0; i < student.getMatiereIns().size(); i++) {

            Matiere matiere = student.getMatiereIns().get(i);
            data[i][0] = matiere.getCode();
            data[i][1] = matiere.getName();
            data[i][2] = Integer.toString(matiere.getCredit());
            data[i][3] = Integer.toString(matiere.getPrice());
            priceTot += matiere.getPrice();
            k++;
        }
        data[k][4] = Integer.toString(priceTot);

        payementBtn = new JButton("Procédé au payement");
        payementBtn.setSize(100, 30);
        payementBtn.requestFocus();
        payementBtn.addActionListener(new PayementListener());
        matiereModel = new DefaultTableModel(data, column);
        matiereTab = new JTable(matiereModel);
        matiereTab.setEnabled(false);
        matiereTab.setShowGrid(false);
        matiereScroll = new JScrollPane(matiereTab);
        matiereScroll.setSize(800, 500);
        panel = new JPanel();

        panel.add(matiereScroll);
        panel.add(payementBtn);

        frame.add(panel);

        frame.setSize(1000, 400);  //set size of the frame  
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class PayementListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            processRequest();

        }
    }

    @Override
    public void processRequest() {
        frame.setVisible(false);
        setSuccessor(new InformationPayementHandler());
    }

}
