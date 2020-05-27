package Commands;

import Controller.CommandWithLogin;
import Controller.CommandWithObject;
import Controller.CommandWithoutArg;

import java.io.IOException;

/**
 * Removes all movies from collection
 *
 * @author Diana
 */
public class Remove_lower implements CommandWithoutArg, CommandWithObject, CommandWithLogin {
    String whyFailed;
    String name = "remove_lower";
    String username;

    /**
     * @param arg ignore this
     * @return
     */
    @Override
    public Object execute(Object arg) throws IOException {
        return null;
    }

    @Override
    public boolean check(String arg) {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String whyFailed() {
        return whyFailed;
    }

    @Override
    public void setUsername(String login) {
        username = login;
    }
}
