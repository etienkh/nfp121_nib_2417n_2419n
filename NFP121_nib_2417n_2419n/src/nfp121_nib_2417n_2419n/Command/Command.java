package nfp121_nib_2417n_2419n.Command;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Command {
    void execute() throws FileNotFoundException, IOException;
}
