package Commands;

import Controller.CommandWithLogin;
import Controller.CommandWithoutArg;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * shows the last 5 commands
 *
 * @author Diana
 */
public class History implements CommandWithoutArg, CommandWithLogin {
    static ArrayList history = new ArrayList();
    String name = "history";
    String username;

    /**
     * @param arg ignore this
     */
    public Object execute(Object arg) {
        return null;
    }

    public void addToHistory(String commandName) {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setUsername(String login) {
        username = login;
    }
}
