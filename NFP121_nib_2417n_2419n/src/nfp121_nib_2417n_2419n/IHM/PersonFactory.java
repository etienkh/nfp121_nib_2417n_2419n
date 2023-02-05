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

import nfp121_nib_2417n_2419n.Model.Person;
import nfp121_nib_2417n_2419n.Model.Student;
import nfp121_nib_2417n_2419n.Model.Teacher;

public class PersonFactory implements Serializable {

    PersonFactory() {
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

    public static Person getPerson(Person person, String typePerson) throws FileNotFoundException, IOException {
        Person p;
        ArrayList<Person> personList = readAllPerson();
        try {
            if (typePerson.equalsIgnoreCase("student")) {
                p = new Student(person.username, person.firstName, person.lastName, person.password);
            } else {
                p = new Teacher(person.username, person.firstName, person.lastName, person.password, null);
            }
            personList.add(p);
            File output = new File("person");
            FileOutputStream fos = new FileOutputStream(output);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(personList);
            oos.flush();
            oos.close();
            return p;

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return null;
    }
}
