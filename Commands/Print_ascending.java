package Commands;

import Controller.CommandWithoutArg;
import Controller.HumanCollection;
import Human.HumanBeing;

import java.util.stream.Stream;

/**
 * sorts the elements of a collection
 *
 * @author Diana
 */

public class Print_ascending implements CommandWithoutArg {
    HumanCollection humans = new HumanCollection();
    String name = "print_ascending";

    public String getName() {
        return name;
    }

    /**
     * @param arg ignore this
     * @return
     */
    public Object execute(Object arg) {
        return null;
    }
}