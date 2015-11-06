import java.util.*;
/**
 * Created by Nico on 8/27/15.
 */
public class Main {

    public static void main (String[] args) {

        //==========variable declaration==========
        Deck heroes = new Deck();
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<Potion> potions = new ArrayList<Potion>();
        /**
         * Put in this variable ("path"), the path of the file.
         */
        //=========================
        String path = "cards.txt"; //==
        //=========================
        /**
         * Load Generals Potions.
         */
        GeneralPotion newGeneralPotion1 = new GeneralPotion("Empowering", 20);
        potions.add(newGeneralPotion1);
        GeneralPotion newGeneralPotion2 = new GeneralPotion("Empowering", 30);
        potions.add(newGeneralPotion2);
        GeneralPotion newGeneralPotion3 = new GeneralPotion("Empowering", 40);
        potions.add(newGeneralPotion3);
        GeneralPotion newGeneralPotion4 = new GeneralPotion("Empowering", 50);
        potions.add(newGeneralPotion4);
        /**
         * Load Limited Potions.
         */
        LimitedPotion newLimitedPotion1 = new LimitedPotion("Limited");
        potions.add(newLimitedPotion1);
        LimitedPotion newLimitedPotion2 = new LimitedPotion("Limited");
        potions.add(newLimitedPotion2);
        LimitedPotion newLimitedPotion3 = new LimitedPotion("Limited");
        potions.add(newLimitedPotion3);
        LimitedPotion newLimitedPotion4 = new LimitedPotion("Limited");
        potions.add(newLimitedPotion4);
        /**
         * Load Selective Potions .
         */
        SelectivePotion newSelectivePotion1 = new SelectivePotion("Selective","Fuerza", 20);
        potions.add(newSelectivePotion1);
        SelectivePotion newSelectivePotion2 = new SelectivePotion("Selective","Velocidad", 20);
        potions.add(newSelectivePotion2);
        SelectivePotion newSelectivePotion3 = new SelectivePotion("Selective","Poder", 20);
        potions.add(newSelectivePotion3);
        SelectivePotion newSelectivePotion4 = new SelectivePotion("Selective","Fuerza", 20);
        potions.add(newSelectivePotion4);
        /**
         * Load Static Potions.
         */
        StaticPotion newStaticPotion1 = new StaticPotion("Static",20);
        potions.add(newStaticPotion1);
        StaticPotion newStaticPotion2 = new StaticPotion("Static",30);
        potions.add(newStaticPotion2);
        StaticPotion newStaticPotion3 = new StaticPotion("Static",40);
        potions.add(newStaticPotion3);
        StaticPotion newStaticPotion4 = new StaticPotion("Static",50);
        potions.add(newStaticPotion4);
        /**
         * Load Static Potions.
         */
        CocktailPotion newCocktailPotion1 = new CocktailPotion("Cocktail");
        newCocktailPotion1.addPotion(newSelectivePotion1);
        newCocktailPotion1.addPotion(newSelectivePotion2);
        potions.add(newCocktailPotion1);
        CocktailPotion newCocktailPotion2 = new CocktailPotion("Cocktail");
        newCocktailPotion1.addPotion(newSelectivePotion2);
        newCocktailPotion1.addPotion(newSelectivePotion3);
        potions.add(newCocktailPotion2);
        CocktailPotion newCocktailPotion3 = new CocktailPotion("Cocktail");
        newCocktailPotion1.addPotion(newSelectivePotion3);
        newCocktailPotion1.addPotion(newSelectivePotion4);
        potions.add(newCocktailPotion3);
        CocktailPotion newCocktailPotion4 = new CocktailPotion("Cocktail");
        newCocktailPotion1.addPotion(newSelectivePotion1);
        newCocktailPotion1.addPotion(newSelectivePotion4);
        potions.add(newCocktailPotion4);

        //==========play game==========
        heroes.loadDeckFromFile(path);
        Game game = new Game(heroes,potions, 2);
        game.play();
        results = game.getResults();
        for (int i = 0; i < results.size() - 1; i++) {
            System.out.println("==========ROUND " + (i + 1) + "==========");
            System.out.println(results.get(i));
        }
        System.out.println(results.get(results.size() - 1));
    }
}
