import java.util.ArrayList;

/**
 * Created by Mati on 06/11/2015.
 */
public class LimitedPotion extends GeneralPotion {

    private int counter;

    public LimitedPotion(String name) {
        super(name, 20);
        this.counter = 2;
    }

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        if (this.counter != 0) {
            if (this.counter == 2) {
                return super.modify(attributes);
            } else if (this.counter == 1) {
                this.setValue(10);
                return super.modify(attributes);
            }
            --this.counter;
        }
        return attributes;
    }
}
