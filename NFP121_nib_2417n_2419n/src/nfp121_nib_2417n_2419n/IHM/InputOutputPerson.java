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
import java.util.logging.Level;
import java.util.logging.Logger;

import nfp121_nib_2417n_2419n.Model.Person;

public class InputOutputPerson implements Serializable {

    static ArrayList<Person> personList = readAllPerson();

    public static void writePerson(Person p) throws FileNotFoundException, IOException {

        if (p != null) {
            personList.add(p);
            File output = new File("person");
            FileOutputStream fos = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personList);
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

    public static void updatePerson(Person p) throws FileNotFoundException, IOException {
        try {

            for (int i = 0; i < personList.size(); i++) {
                if (p.username.equalsIgnoreCase(personList.get(i).username)) {
                    personList.set(i, p);
                }
            }
            File output = new File("person");
            FileOutputStream fos = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personList);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            Logger.getLogger(InputOutputPerson.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
