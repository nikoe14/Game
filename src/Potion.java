/**
 * Created by Nico on 10/31/15.
 */
public abstract class Potion {

    protected String name;

    public Potion(String name) {
        this.name = name;
    }

    public abstract Attribute modify(Attribute attributes);

    public abstract Attribute getModifiedValue(Attribute attributes);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}