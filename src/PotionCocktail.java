import java.util.ArrayList;

/**
 * Created by Nico on 11/3/15.
 */
public class PotionCocktail extends Potion {
    ArrayList<Potion> potions;

    public PotionCocktail(String name) {
        super(name);
        this.potions = new ArrayList<Potion>();
    }

    public void addPotion(Potion potionToAdd) {

    }

    public ArrayList<Attribute> modify(ArrayList<Attribute> attributes) {
        return attributes;
    }
}
