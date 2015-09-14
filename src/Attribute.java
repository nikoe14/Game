/**
 * Created by Nico on 8/26/15.
 */
public class Attribute {
    private String name;
    private int value;
    private int highestWins;

    public Attribute(String name, int value, int highestWins) {
        this.name = name;
        this.value = value;
        this.highestWins = highestWins;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getWinType() {
        return this.highestWins;
    }

    public void setWinType(int highestWins) {
        this.highestWins = highestWins;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int valor) {
        this.value = valor;
    }

    /**
     * This method return the winning attribute.
     * @param attribute: Attribute of the opponent.
     * @return: winning attribute
     */
    public Attribute winningAttribute(Attribute attribute) {
        if ((attribute.getValue() * highestWins) > (this.value * highestWins))
            return attribute;
        else
            if ((attribute.getValue() * highestWins) < (this.value * highestWins))
                return this;
        else
            return null;
    }
}
