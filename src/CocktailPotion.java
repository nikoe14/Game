import java.util.ArrayList;

/**
 * Created by Nico on 11/3/15.
 */
public class CocktailPotion extends Potion {
    ArrayList<Potion> potions;

    public CocktailPotion(String name) {
        super(name);
        this.potions = new ArrayList<Potion>();
    }

    public void addPotion(Potion potionToAdd) {
        this.potions.add(potionToAdd);
    }

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        ArrayList<Attribute> newAttributes = new ArrayList<Attribute>();
        if (potions !=null) {
            for (Potion potion : potions)
                potion.modify(newAttributes);
        }
        return newAttributes;
    }
}
