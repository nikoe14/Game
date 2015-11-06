import java.util.ArrayList;

/**
 * Created by Nico on 11/3/15.
 */
public class CocktailPotion extends Potion {
    /**
     * This potion, combine others in order to construct new potions.
     */

    ArrayList<Potion> potions;

    public CocktailPotion(String name) {
        super(name);
        this.potions = new ArrayList<Potion>();
    }

    public void addPotion(Potion potionToAdd) {
        this.potions.add(potionToAdd);
    }

    /**
     * This method modify the value in game with the potions values of the potions list.
     * @param attribute
     * @return
     */
    public Attribute modify(Attribute attribute) {
        return getModifiedValue(attribute);
    }

    public Attribute getModifiedValue(Attribute attribute) {
        Attribute newAttribute = new Attribute(attribute.getName(), attribute.getValue(), attribute.getWinType());
        if (potions != null) {
            for (Potion potion : potions)
                newAttribute = potion.modify(newAttribute);
        }
        return newAttribute;
    }
}
