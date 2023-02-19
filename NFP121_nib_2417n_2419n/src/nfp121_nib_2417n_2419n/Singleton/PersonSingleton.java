package nfp121_nib_2417n_2419n.Singleton;

import nfp121_nib_2417n_2419n.Model.Person;

public class PersonSingleton {

    private static Person person;

    private PersonSingleton() {
    }

    public static Person getInstance(Person p) {
        if (person != null)
            return person;
        person = p;
        return person;
    }
}
