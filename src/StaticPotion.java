import java.util.ArrayList;

/**
 * Created by Nico on 11/6/15.
 */
public class StaticPotion extends Potion {
    /**
     * This potion, affect all attributes with the same value.
     */
    private double value;

    public StaticPotion(String name, double value) {
        super(name);
        this.value = value;
    }
    /**
     * This method modify the value in game with the potion's value.
     * @param attribute
     * @return
     */
    public Attribute modify(Attribute attribute) {
        Attribute newAttribute = new Attribute(attribute.getName(),value,attribute.getWinType());
        return newAttribute;
    }
}
