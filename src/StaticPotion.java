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
        return getModifiedValue(attribute);
    }

    public Attribute getModifiedValue(Attribute attribute) {
        return new Attribute(attribute.getName(), value, attribute.getWinType());
    }
}
