
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
        Deck heroes = new Deck();
        int numAttributtes;
        String path = "cards.txt";
        ArrayList<String> results = new ArrayList<String>();

        //==========play game==========
        heroes.loadDeckFromFile(path);
        System.out.println("Deck: "+ heroes.check());
        Game game = new Game(heroes,2);
        game.play();
        results = game.Results();
        for (int i = 0; i < results.size() - 1; i++) {
            System.out.println("==========RONDA " + i +"==========" );
            System.out.println(results.get(i));
        }
        System.out.println(results.get(results.size() - 1));
    }
}
