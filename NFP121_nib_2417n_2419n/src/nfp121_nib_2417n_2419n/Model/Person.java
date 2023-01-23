/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

/**
 *
 * @author Georges
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

 public class Person implements Serializable {
    public int id ;
    public  String username;
    public String firstName;
    public String lastName;
    public String password;
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
       public Person(String username , String firstName,String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        
        if(readAllPerson().size() == 0){
            id = 1;
        }
        else{
         id = readAllPerson().get(readAllPerson().size()-1).id  + 1;  
        }
        
    }
       public String toString(){
           return this.username+" "+this.firstName+" "+this.lastName+" "+this.password;
       }

}
