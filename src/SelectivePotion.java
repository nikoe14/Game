import java.util.ArrayList;

/**
 * Created by Nico on 11/1/15.
 */

public class SelectivePotion extends Potion{
    /**
     * This potion, only affects a single target.
     */
    private String target;
    private double value;

    public SelectivePotion(String name, String target, double value) {
        super(name);
        this.target = target;
        this.value = value;
    }
    /**
     * This method modify the value in game with the potion's value.
     * @param attribute
     * @return
     */
    public Attribute modify(Attribute attribute) {
        if (attribute.getName() == target) {
            Attribute newAttribute = new Attribute(attribute.getName(), attribute.getValue(), attribute.getWinType());
            double attributeValue = attribute.getValue();
            double valueToApply = (attributeValue * (value / 100));
            newAttribute = new Attribute(attribute.getName(), (attribute.getValue() + valueToApply), attribute.getWinType());
            return newAttribute;
        } else
            return attribute;
    }
}
