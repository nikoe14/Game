/**
 * Created by Mati on 06/11/2015.
 */
public class LimitedPotion extends GeneralPotion {

    private int counter;

    public LimitedPotion(String name) {
        super(name, 20);
        this.counter = 2;
    }


    /**
     * This method modify the value in game with the potion's value.
     * @param attribute
     * @return
     */
    @Override
    public Attribute modify(Attribute attribute) {
        Attribute newAttr = getModifiedValue(attribute);
        --this.counter;
        return newAttr;
    }

    /**
     * This method modify the value in game with the potion's value, but is used just for consult the actual value.
     * @param attribute
     * @return
     */
    @Override
    public Attribute getModifiedValue(Attribute attribute) {
        if (this.counter != 0) {
            if (this.counter == 2) {
                return super.getModifiedValue(attribute);
            } else if (this.counter == 1) {
                this.setValue(10);
                return super.getModifiedValue(attribute);
            }
        }
        return attribute;
    }
}
