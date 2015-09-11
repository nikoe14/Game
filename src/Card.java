import java.util.ArrayList;

/**
 * Created by Nico on 8/26/15.
 */
public class Card {
    private String name;
    private ArrayList<Attribute> attributes = new ArrayList<Attribute>();
    public Card() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAttributtes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public int getAttribute(int attribute) {
        if (!this.attributes.isEmpty()) {
        	if (this.attributes.get(attribute).getWinType()== 1)
        		return this.attributes.get(attribute).getValue();
        	else
        		return (-1 * this.attributes.get(attribute).getValue());
        }
        else
            return -1;
    }

    public int getAttributeCondition(int attribute) {
        if (!this.attributes.isEmpty()) {
            return this.attributes.get(attribute).getWinType();
        } else
            return 1;
    }

    public ArrayList<Attribute> getAttributes() {
        return this.attributes;
    }

    public int getAttributesAmount() {
        return attributes.size();
    }

    public String getAttributesName(int pos) {return attributes.get(pos).getName();}

    public Card winningCard(Card opponentCard, int attributeInGame) {
        Attribute winningAttribute = opponentCard.attributes.get(attributeInGame).winningAttribute(this.attributes.get(attributeInGame));
        if (winningAttribute == this.attributes.get(attributeInGame))
            return this;
        else
            if (winningAttribute == null)
                return null;
        else {
                return opponentCard;
            }
    }
}
