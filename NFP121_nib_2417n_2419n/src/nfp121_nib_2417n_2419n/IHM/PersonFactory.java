/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.IHM;

import java.awt.Font;
import java.io.*;
import java.util.ArrayList;
import nfp121_nib_2417n_2419n.Model.*;

/**
 *
 * @author Georges
 */
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PersonFactory implements Serializable {

    ArrayList<Person> personList = readAllPerson();

    PersonFactory() {
    }

    public ArrayList<Person> readAllPerson() {
        ArrayList<Person> list = new ArrayList<Person>();
        File file = new File("person");
        try {

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Person>) ois.readObject();
            ois.close();

        } catch (Exception exc) {
        }
        return list;
    }

    public void createPerson(Person person, String typePerson) throws FileNotFoundException, IOException {
        Person p;

        try {
            for (Person per : personList) {

                if (per.username.equalsIgnoreCase(person.username)) {          
                    throw new existUsername(person.username);

                }

            }

        } catch (existUsername eu) {
            System.out.println(eu);
        }

        try {
            if (typePerson.equalsIgnoreCase("student")) {
                p = new Student(person.username, person.firstName, person.lastName, person.password);
            } else {
                p = new Teacher(person.username, person.firstName, person.lastName, person.password, null);
            }
            System.out.println(person.id);
            personList.add(p);
            File output = new File("person");
            FileOutputStream fos = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            registrationFormIHM.getFrame().setVisible(false);
            oos.writeObject(personList);
            
            oos.flush();
            oos.close();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

    class existUsername extends Exception {

        existUsername(String mes) {

            JLabel label = new JLabel("This username already exist");
            label.setFont(new Font("calibri", Font.BOLD, 15));
            JOptionPane.showMessageDialog(null, label, "Error", JOptionPane.ERROR_MESSAGE);
            
        }
    }

}