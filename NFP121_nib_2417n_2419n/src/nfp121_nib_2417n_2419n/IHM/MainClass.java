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
import java.util.Arrays;
import nfp121_nib_2417n_2419n.Model.Matiere;
import nfp121_nib_2417n_2419n.Model.Person;

public class MainClass implements Serializable {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        LoginForm loginForm = new LoginForm();
        Matiere m = new Matiere("NFP121", "Programmation Avancee", 6,
                new ArrayList<String>(Arrays.asList("11/11/2022 - Session 1", "15/12/2022 - Session 2", " 10/1/2023 - Session 3")),
                new ArrayList<String>(Arrays.asList("Chapitre 1 : Partie 1 : Patron de conception : Composite", "Chapitre 1 : Partie 2 : Patron de conception : Factory", "Chapitre 2: Reflexivite")),
                new ArrayList<String>(Arrays.asList("Modeliser mieux les projets", "Posseder une idee sur les different patron de conception", "Savoir les fonctions definies en java")),
                new ArrayList<String>(Arrays.asList("Chapitre 1: Composite", "Chapitre 2: Adapter", "Chapitre 3: Strategy", "Chapitre 4: Reflexivite")),
                new ArrayList<String>(Arrays.asList("Chapitre1_Composite.pdf", "Chapitre2_Strategy.pdf", "Chapitre3_Reflexivite.ppt")),
                new ArrayList<String>(Arrays.asList("Session1.mov", "Session2.mov", "Session3.mov")));
        ArrayList<Matiere> matieresList = new ArrayList<Matiere>(Arrays.asList(m));
        File output = new File("matiere");
        FileOutputStream fos = new FileOutputStream(output);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(matieresList);
        oos.flush();
        oos.close();
        ArrayList<Matiere> list = new ArrayList<Matiere>();
        File file = new File("matiere");
        try {
            
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Matiere>) ois.readObject();
            ois.close();
            System.out.print(list.get(0));
        } catch (Exception exc) {
        }
    }
}
