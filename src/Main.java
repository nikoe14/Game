
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
        ArrayList<String> results = new ArrayList<String>();

        /**
         * Put in this variable ("path"), the path of the file.
         */
        //=========================
        String path = "cards.txt"; //==
        //=========================

        //==========play game==========
        heroes.loadDeckFromFile(path);

        if (heroes.check()) {
            System.out.println("Valid Deck: " + heroes.check());
            Game game = new Game(heroes, 2);
            game.play();
            results = game.Results();
            for (int i = 0; i < results.size() - 1; i++) {
                System.out.println("==========ROUND " + i + "==========");
                System.out.println(results.get(i));
            }
            System.out.println(results.get(results.size() - 1));
        } else {
            System.out.println("Valid Deck: " + heroes.check());
        }
    }
}
