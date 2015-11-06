import java.util.ArrayList;

/**
 * Created by Nico on 11/6/15.
 */
public class StaticPotion extends Potion {

    private double value;

    public StaticPotion(String name, double value) {
        super(name);
        this.value = value;
    }

    public Attribute modify(Attribute attribute) {
        Attribute newAttribute = new Attribute(attribute.getName(),value,attribute.getWinType());
        return newAttribute;
    }
}
