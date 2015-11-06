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
        return getModifiedValue(attribute);
    }

    public Attribute getModifiedValue(Attribute attribute) {
        if (attribute.getName().equals(target)) {
            double attributeValue = attribute.getValue();
            double valueToApply = (attributeValue * (value / 100));
            return new Attribute(attribute.getName(), (attribute.getValue() + valueToApply), attribute.getWinType());
        } else
            return attribute;
    }
}
