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
        if (validCard(newCard))
            cards.add(0, newCard);
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
        cards.add(newCard);
    }

    /**
     * Removes the last card and returns it.
     * @return: the last card of the deck.
     */
    public Card getCard() {
        if (!cards.isEmpty()) {
            Card currentCard = cards.get(cards.size() - 1);
            cards.remove(cards.get(cards.size() - 1));
            return currentCard;
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
    public String getAttriuteName(int pos) {
        return (cards.get(pos).getName());
    }
/*
    public void showCard(Card card) {
        System.out.println("Cantidad de Atributos: " + card.getAttributesAmount());
    }
*/
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

    public boolean check() {
    	boolean aux = true;
    	if (cards.size()>1) {
    	    Card card = cards.get(0);
    	    int cantAttr = card.getAttributesAmount();
    	    ArrayList<Attribute> attr = card.getAttributes();
    	    int i =1;
    	    while (i<cards.size()&&(aux)){
    		    if (!((cantAttr == cards.get(i).getAttributesAmount()) && (validAttributes(attr, cards.get(i).getAttributes()))))
    			    aux = false;
                i++;
		        }
            return aux;
        } else
		    return false;//1 card
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
    private boolean validCard(Card newCard) {
        if ((cards.size() == 0) && (validAttributesAmount(newCard)))
            return true;
        else {
            int newCardAttributesAmount = newCard.getAttributesAmount();
            int deckAttributesAmount = cards.get(0).getAttributesAmount();
            if (validAttributesAmount(newCard)) {
                return (newCardAttributesAmount == deckAttributesAmount);
            }
            else return false;
        }

    }

}