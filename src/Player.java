import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Nico on 8/30/15.
 */
public class Player {
    private Deck deck;
    private String name;

    public Player(Deck deck, String name) {
        this.deck = deck;
        this.name = name;
    }

    public Card play() {
        if (deck.getQuantityCards() > 0) {
            return this.deck.getCard();
        }
        else
            return null;
    }

    public Player(String name) {
    	this.name=name;
    }

    public String getName(){
    	return name;
    }
    public void addCard(Card card) {
        this.deck.addCard(card);
    }

    public Card getCard() {
        return this.deck.getCard();
    }

    public int remainingCards() {
        return deck.getQuantityCards();
    }

    public void removeCard() {
        deck.removeCard();
    }

    /**
     * Deliver the cards that was in play to winning player.
     * @param : array the cards in play.
     */
    public void saveCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            this.addCard(card);
        }
    }

    /**
     * randomly selects an attribute for the game.
     * @return index's number of the array list of the attributes.
     */
    public int selectAttribute() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(deck.getAttributesAmount());
    }

}