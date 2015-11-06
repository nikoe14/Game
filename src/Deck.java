import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Deck {
    private int attributesAmount;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Deck() {
    }

    /**
     * adds a new card of the deck.
     * @param newCard: the new card of the deck.
     */
    public void addCard(Card newCard) {
        if (newCard != null) {
            if (this.cards.size() > 0) {
                Card baseCard = this.cards.get(0);
                if (baseCard.equals(newCard)) {
                    this.cards.add(newCard);
                }
            } else {
                this.cards.add(newCard);
            }
        }
    }
    /**
     *
     * @param name: name of the new deck.
     * @param attributtes: ArrayList of attributes.
     */
    public void createCard(String name, ArrayList<Attribute> attributtes) {
        Card newCard = new Card();
        newCard.setName(name);
        newCard.setAttributtes(attributtes);
        attributesAmount = attributtes.size();
        addCard(newCard);
    }

    /**
     * @return: the last card of the deck.
     */
    public Card getCard() {
        if (!cards.isEmpty()) {
            return cards.get(cards.size() - 1);
        }
        else
            return null;
    }

    /**
     *
     * @return: Quantity of cards of the deck.
     */
    public int getQuantityCards() {
        return this.cards.size();
    }

    /**
     * Checked if deck isn't empty and remove de last card.
     */
    public void removeCard() {
        if (!cards.isEmpty())
            this.cards.remove(this.cards.size()-1);
    }

    /**
     * This method took the last card in the deck and asked for the attributes amount.
     * @return attributes amount.
     */
    public int getAttributesAmount() {
        Card card = new Card();
        if (this.cards.size() != 0) {
            card = cards.get(0);
            return card.getAttributesAmount();
        }
        return 0;
    }

    /**
     *
     * @param pos: attribute's posicion.
     * @return: attribute's name.
     */
    public String getAttributeName(int pos) {
        return (cards.get(pos).getName());
    }

    /**
     * Load cards from a file.
     * @param path: path of the file.
     */
    public void loadDeckFromFile(String path) {
        String line;
        String[] lineArray = new String[0];
        FileReader fr = null;
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        try {
            while ((line = br.readLine())!=null) {
                ArrayList<Attribute> attributes = new ArrayList<Attribute>();
                lineArray = line.split(",");
                for (int i = 1; i < lineArray.length; i = i +3) {
                    Attribute newAttribute = new Attribute(lineArray[i], Integer.parseInt(lineArray[i+1]), Integer.parseInt(lineArray[i+2]));
                    attributes.add(newAttribute);
                }
                createCard(lineArray[0], attributes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validAttributes(ArrayList<Attribute> attributesA, ArrayList<Attribute> attributesB) {
    	boolean error = false;
    	int i =0;
    	while (!(error)&& (i<attributesA.size())) {
    		String nameAttributeA = attributesA.get(i).getName();
    		String nameAttributeB = attributesB.get(i).getName();
    		if (!nameAttributeA.equals(nameAttributeB)) {
    			error=true;
    		}
    	    i++;
    	}
    	return !error;
    }

    /**
     * This method controls the attributes' amount are correct.
     * @param card: card
     * @return true if the attributes amount is valid.
     */
    private boolean validAttributesAmount(Card card) {
     int attributesAmount = card.getAttributesAmount();
        return ((attributesAmount > 3) && (attributesAmount < 7));
    }

    /**
     * This method validates that the card's attributes are the same.
     * @param newCard
     * @return if the card is valid.
     */

    private boolean validCard(Card cardToVerify) {
        if (!cards.isEmpty()) {
            Card firstCard = cards.get(0);

            return firstCard.equals(cardToVerify);
        } else return true;
    }

}