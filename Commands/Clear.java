package Commands;

import Controller.CommandWithLogin;
import Controller.CommandWithoutArg;
import Controller.HumanCollection;

/**
 * Removes all movies from collection
 *
 * @author Polina
 */
public class Clear implements CommandWithoutArg, CommandWithLogin {
    String name = "clear";
    String username;

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

    @Override
    public void setUsername(String login) {
        username = login;
    }
}