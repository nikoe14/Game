import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nico on 10/31/15.
 */
public abstract class Potion {

    //private HashMap<String, Integer> targets;
    protected String name;
    private int fixedValue;

    public Potion(String name) {
        this.name = name;
        this.fixedValue = 0;
    }
    /**
     * This method modify the value in game with the potion's value.
     * @param attribute
     * @return
     */
    public abstract Attribute modify(Attribute attributes);

    public void setName(String name) {
        this.name = name;
    }

    public void setFixedValue(int value) {
        this.fixedValue = value;
    }

    public String getName() {
        return this.name;
    }

    public int getFixedValue() {
        return this.fixedValue;
    }

    /*
    public void addTarget(String target, int value) {
       this.targets.put(target, value);
    }
    */

}