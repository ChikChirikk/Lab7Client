package Commands;

import Controller.CommandWithLogin;
import Controller.Commandable;
import Controller.HumanCollection;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Removes element by its id
 *
 * @author Diana
 */
public class Remove_by_id implements Commandable, CommandWithLogin {
    String name = "remove_by_id";
    String username;

    public String getName() {
        return name;
    }

    /**
     * @param arg id
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
