package Commands;
import Controller.*;
import Human.HumanBeing;
/**
 * Remove first element
 * @author Polina
 */
public class Remove_first implements CommandWithoutArg, CommandWithLogin {
	String name = "remove_first";
	String username;
    /**
	 * @param arg ignore this
	 * @return
	 */
	public Object execute(Object arg){
		return null;
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