import com.sun.tools.doclint.HtmlTag;

/**
 * Created by Nico on 8/26/15.
 */
public class Attribute {
    private String name;
    private double value;
    private int highestWins;

    public Attribute(String name, double value, int highestWins) {
        this.name = name;
        this.value = value;
        this.highestWins = highestWins;
    }

    public double getValue() {
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

    public void setValue(double valor) {
        this.value = valor;
    }

    /**
     * This method return the winning attribute.
     * @param attribute: Attribute of the opponent.
     * @return: winning attribute
     */
    public int confrontation(Attribute attribute) {
        if ((attribute.getValue() * highestWins) > (this.value * highestWins)) {
            return 1;
        }
        else
            if ((attribute.getValue() * highestWins) < (this.value * highestWins)) {
                return -1;
            }
        else
            return 0;
    }
    public boolean equals(Object attributeToVerify) {
        Attribute attribute = (Attribute)attributeToVerify;
        return this.name.equals(attribute.getName());
    }
}
