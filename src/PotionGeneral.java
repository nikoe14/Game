import java.util.ArrayList;

/**
 * Created by Nico on 11/1/15.
 */
public class PotionGeneral extends Potion {

    private int value;

    public PotionGeneral(String name, int value) {
        super(name);
        this.value = value;
    }

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
        for(Attribute attribute : attributes) {
            Attribute newAttribute = new Attribute(attribute.getName(),(attribute.getValue()*1.2),attribute.getWinType());
            newAttributes.add(newAttribute);
        }
        return newAttributes;
    }
}
