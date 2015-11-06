import java.util.ArrayList;

/**
 * Created by Nico on 11/1/15.
 */

public class PotionSelective extends Potion{

    private String target;
    private double value;

    public PotionSelective(String name, String target, double value) {
        super(name);
        this.target = target;
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
