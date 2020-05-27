package Commands;

import Controller.Commandable;
import Controller.HumanCollection;

/**
 * print the number of elements whose impact Speed field value is less than the specified value
 *
 * @author Diana
 */
public class Count_less_than_impact_speed implements Commandable {
    HumanCollection humans = new HumanCollection();
    String name = "count_less_than_impact_speed";

    public String getName() {
        return name;
    }

    /**
     * @param arg specified value
     * @return
     */
    public Object execute(Object arg) {
        return null;
    }
}