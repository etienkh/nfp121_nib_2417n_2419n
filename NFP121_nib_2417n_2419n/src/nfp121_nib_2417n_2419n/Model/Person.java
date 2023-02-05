/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfp121_nib_2417n_2419n.Model;

import static nfp121_nib_2417n_2419n.IHM.InputOutputPerson.readAllPerson;

import java.io.Serializable;
public class Person implements Serializable {

    public int id;
    public String username;
    public String firstName;
    public String lastName;
    public String password;

    public Person(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        if (readAllPerson().isEmpty()) {
            id = 1;
        } else {
            id = readAllPerson().get(readAllPerson().size() - 1).id + 1;
        }
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString() {
        return this.username + " " + this.firstName + " " + this.lastName + " " + this.password;
    }

}
