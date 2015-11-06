import java.util.ArrayList;

/**
 * Created by Nico on 11/6/15.
 */
public class InnocuousPotion extends Potion {
    /**
     * This potion, doesn't affect.
     */
    public InnocuousPotion() {
        super("Innocuous");
    }

    /**
     * This method return the attribute without modification.
     * @param attribute
     * @return
     */
    public Attribute modify(Attribute attribute) {
        return attribute;
    }
}
