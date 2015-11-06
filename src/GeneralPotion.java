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

    public Attribute modify(Attribute attribute) {
        double attributeValue = attribute.getValue();
        double valueToApply = (attributeValue * (value / 100));
        return new Attribute(attribute.getName(), (attribute.getValue() + valueToApply), attribute.getWinType());
    }
}
