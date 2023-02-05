/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nfp121_nib_2417n_2419n.IHM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import nfp121_nib_2417n_2419n.Model.Teacher;
import nfp121_nib_2417n_2419n.Teacher.TeacherHomePage;
import nfp121_nib_2417n_2419n.Model.Person;

/**
 *
 * @author Georges
 */
public class InputOutputPerson implements Serializable {

    static ArrayList<Person> personList = readAllPerson();

    public static void writePerson(Person p) throws FileNotFoundException, IOException {

        if (p != null) {
            personList.add(p);
            File output = new File("person");
            FileOutputStream fos = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personList);
            if (p.getClass() == Teacher.class) {
                new TeacherHomePage((Teacher) p);
            }
            oos.flush();
            oos.close();
        }

    }

    public static ArrayList<Person> readAllPerson() {
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
}
