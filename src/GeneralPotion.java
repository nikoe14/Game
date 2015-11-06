import java.util.ArrayList;

/**
 * Created by Nico on 11/1/15.
 */
public class GeneralPotion extends Potion {

    private double value;

    public GeneralPotion(String name, double value) {
        super(name);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
        for(Attribute attribute : attributes) {
            Attribute newAttribute = new Attribute(attribute.getName(),(attribute.getValue()*value),attribute.getWinType());
            newAttributes.add(newAttribute);
        }
        return newAttributes;
    }
}
