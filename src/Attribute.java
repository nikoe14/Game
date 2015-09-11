import java.util.Map.Entry;
/**
 * Created by Nico on 8/26/15.
 */
public class Attribute {
    private String name;
    private int valor;
    private int highestWins;

    public Attribute(String name, int valor, int highestWins) {
        this.name = name;
        this.valor = valor;
        this.highestWins = highestWins;
    }

    public int getValor() {
        return valor;
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

    public void setValor(int valor) {
        this.valor = valor;
    }
}
