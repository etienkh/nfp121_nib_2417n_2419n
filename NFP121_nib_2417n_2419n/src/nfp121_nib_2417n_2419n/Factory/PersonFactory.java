package nfp121_nib_2417n_2419n.Factory;

import java.io.*;
import nfp121_nib_2417n_2419n.Model.*;

import java.io.Serializable;

public class PersonFactory implements Serializable {

    PersonFactory() {
    }

    public static Person getPerson(Person person, String typePerson) throws FileNotFoundException, IOException {

        if (typePerson.equalsIgnoreCase("student")) {
            return new Student(person.username, person.firstName, person.lastName, person.password);
        } else {
            return new Teacher(person.username, person.firstName, person.lastName, person.password, null);
        }

    }

}
