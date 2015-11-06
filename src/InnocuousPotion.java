/**
 * Created by Nico on 11/6/15.
 */
public class InnocuousPotion extends Potion {

    public InnocuousPotion() {
        super("Innocuous");
    }

    public Attribute modify(Attribute attribute) {
        return attribute;
    }
}
