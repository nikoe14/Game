import java.util.ArrayList;

/**
 * Created by Nico on 11/4/15.
 */

public class HauntedCard extends Card {
    //private Potion potion = new PotionGeneral(name, 13);

    public HauntedCard() {
        super();
    }

    public void addPotion (Potion potion) {
        //this.potion = potion;
    }
    public int confrontation(Card opponentCard, int attributeInGame) {
        //ArrayList<Attribute> attributesOpponent = potion.modify(opponentCard.getAttributes());
        //ArrayList<Attribute> cardAttributesModify = potion.modify(this.getAttributes());

        //return attributesOpponent.get(attributeInGame).confrontation(cardAttributesModify.get(attributeInGame));
        //return opponentCard.attributes.get(attributeInGame).confrontation(this.attributes.get(attributeInGame));
        return 1;
    }

}