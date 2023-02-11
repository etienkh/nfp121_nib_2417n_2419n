package nfp121_nib_2417n_2419n.Command;

import java.io.FileNotFoundException;
import java.io.IOException;

public class invoker {
    public Command command;

    public invoker(Command c) {
        this.command = c;
    }

    public void execute() throws FileNotFoundException, IOException {
        this.command.execute();
    }
}
