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

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
        for(Attribute attribute : attributes) {
            Attribute newAttribute = new Attribute(attribute.getName(),value,attribute.getWinType());
            newAttributes.add(newAttribute);
        }
        return newAttributes;
    }
}
