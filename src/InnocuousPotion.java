import java.util.ArrayList;

/**
 * Created by Nico on 11/6/15.
 */
public class InnocuousPotion extends Potion {

    public InnocuousPotion() {
        super("Innocuous");
    }

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        return attributes;
    }
}
