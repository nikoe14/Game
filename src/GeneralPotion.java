import java.util.ArrayList;

/**
 * Created by Nico on 11/1/15.
 */
public class GeneralPotion extends Potion {
    /**
     * This potion, affect equally to all attributes of the card.
     */
    private double value;

    public GeneralPotion(String name, double value) {
        super(name);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /**
     * This method set the potion's value.
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * This method modify the value in game with the potion's value.
     * @param attribute
     * @return
     */
    public Attribute modify(Attribute attribute) {
        Attribute newAttribute = new Attribute(attribute.getName(),attribute.getValue(),attribute.getWinType());
        double attributeValue = attribute.getValue();
        double valueToApply = (attributeValue * (value/100));
        newAttribute = new Attribute(attribute.getName(),(attribute.getValue() + valueToApply),attribute.getWinType());
        return newAttribute;
    }
}
