package nfp121_nib_2417n_2419n.Singleton;

import java.io.IOException;

import nfp121_nib_2417n_2419n.Model.Person;

public class PersonSingleton {
    
        private static Person person;
        
        public static Person getInstance(Person p){
            if(person != null)
                return person;
            person = p;
            return person;
        }
}
