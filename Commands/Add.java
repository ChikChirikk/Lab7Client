package Commands;

import Controller.CommandWithLogin;
import Controller.CommandWithObject;
import Controller.CommandWithoutArg;
import Controller.HumanCollection;
import Human.HumanBeing;


public class Add implements CommandWithObject, CommandWithoutArg, CommandWithLogin {
    String name = "add";
    String username;

    public String getName() {
        return name;
    }

    public Object execute(Object arg) {
        return null;
    }

    @Override
    public boolean check(String arg) {
        return false;
    }

    @Override
    public String whyFailed() {
        return null;
    }

    @Override
    public void setUsername(String login) {
        username = login;
    }
}