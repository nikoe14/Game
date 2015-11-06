import java.util.ArrayList;

/**
 * Created by Nico on 8/26/15.
 */
public class Card {
    private String name;
    private ArrayList<Attribute> attributes;
    private Potion potion;

    public Card(){
        attributes = new ArrayList<Attribute>();
        potion = new InnocuousPotion();
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAttributtes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     *
     * @param attribute: attribute in game.
     * @return the attribute selected for the player.
     */
    public double getAttributeValue(int attribute) {
        if (!this.attributes.isEmpty()) {
        	if (this.attributes.get(attribute).getWinType()== 1)
        		return this.attributes.get(attribute).getValue();
        	else
        		return (-1 * this.attributes.get(attribute).getValue());
        }
        else
            return -1;
    }

    /**
     *
     * @param attribute
     * @return attribute in game
     */
    public int getAttributeCondition(int attribute) {
        if (!this.attributes.isEmpty()) {
            return this.attributes.get(attribute).getWinType();
        } else
            return 1;
    }

    public int getAttributesAmount() {
        return attributes.size();
    }

    public String getAttributeName(int pos) {
        return attributes.get(pos).getName();
    }

    /**
     * Return the winning card.
     * @param opponentCard: The opponent's card.
     * @param attributeInGame: attribute in game.
     * @return
     */
    public int confrontation(Card opponentCard, int attributeInGame) {
        ArrayList<Attribute> attributesOpponent = potion.modify(opponentCard.getAttributes());
        ArrayList<Attribute> cardAttributesModify = potion.modify(this.getAttributes());
        //return opponentCard.attributes.get(attributeInGame).confrontation(this.attributes.get(attributeInGame));
        return attributesOpponent.get(attributeInGame).confrontation(cardAttributesModify.get(attributeInGame));
    }

    public ArrayList<Attribute> getAttributes(){
        return this.attributes;
    }

    public boolean equals(Object cardCompare) {
        Card cardCompared = (Card)cardCompare;
        if ((!this.name.equals(cardCompared.getName())) &&
                (this.getAttributesAmount() == cardCompared.getAttributesAmount())) {
            ArrayList<Attribute> attributes = cardCompared.getAttributes();
            for (Attribute attribute : attributes) {
                if (!this.attributes.contains(attribute)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public Potion getPotion(Potion potion) {
        return this.potion;
    }

    public String toString() {
        String string = this.name;

        if (this.potion != null) {
            string += " <" + this.potion.getName() + ">";
        }

        string += ": {";

        for (int i = 0; i < this.attributes.size(); i++) {
            string += "[" + this.attributes.get(i).getName() + ": ";
            string += this.attributes.get(i).getValue() + "]";
            if (i != this.attributes.size()) {
                string += ",";
            }
        }

        string += "}";

        return string;
    }
}
