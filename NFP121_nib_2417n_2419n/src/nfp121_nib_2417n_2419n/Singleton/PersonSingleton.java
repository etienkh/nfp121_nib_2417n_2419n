package nfp121_nib_2417n_2419n.Singleton;

import java.io.IOException;
import static nfp121_nib_2417n_2419n.IHM.PersonFactory.getPerson;
import nfp121_nib_2417n_2419n.Model.Person;

public class PersonSingleton {
    
        private static Person person;
        
        public static Person getInstance(Person p, String typePerson) throws IOException{
            if(person != null)
                return person;
            person = getPerson(p, typePerson);
            return person;
        }
}
