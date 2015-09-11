
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.*;
/**
 * Created by Nico on 8/27/15.
 */
public class Main {
    public static void main (String[] args) {

        //==========variable declaration==========
        String attributeName;
        int attributeValue;
        ArrayList<Attribute> attributes = new ArrayList<Attribute>();
        ArrayList<Attribute> attributes2 = new ArrayList<Attribute>();
        Deck heroes = new Deck();
        String name;
        int numAttributtes;
        ArrayList<Card> cards = new ArrayList<Card>();
        String path = "cards.txt";
        String[] lineArray = new String[0];
        //==========add a card with attributes==========
        heroes.loadDeckFromFile(path);
        System.out.println("El maso es valido: "+ heroes.check());
        //System.out.println("Cantidad de cartas: " + heroes.getQuantityCards());
        Game game = new Game(heroes,2);
        game.play();
        
        System.out.println("el juego termino");
        //System.out.println(autos.getQuantityCards());
    }
}
