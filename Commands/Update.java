package Commands;

import Controller.CommandWithLogin;
import Controller.CommandWithObject;

/**
 * add update element in collection by its id
 *
 * @author Polina
 */
public class Update implements CommandWithObject, CommandWithLogin {
    static long arg;
    String whyFailed;
    String name = "update";
    String username;

    public String getName() {
        return name;
    }

    /**
     * @param hum id of element
     * @return
     */
    public Object execute(Object hum) {
        return null;
    }


    @Override
    public boolean check(String arg) {
        return false;
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

