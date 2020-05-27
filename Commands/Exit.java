package Commands;

import Controller.CommandWithoutArg;

import java.io.IOException;

/**
 * complete the program
 *
 * @author Polina
 */
public class Exit implements CommandWithoutArg {
    String name = "exit";

    /**
     * @param arg ignore this
     * @return
     */
    @Override
    public Object execute(Object arg) throws IOException {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }
}
