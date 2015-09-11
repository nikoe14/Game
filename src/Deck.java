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
    public void addCard(Card newCard) {
        cards.add(0, newCard);
    }

    public void createCard(String name, ArrayList<Attribute> attributtes) {
        Card newCard = new Card();
        newCard.setName(name);
        newCard.setAttributtes(attributtes);
        attributesAmount = attributtes.size();
        cards.add(newCard);
    }

    public Card getCard() {
        if (!cards.isEmpty()) {
            Card currentCard = cards.get(cards.size() - 1);
            cards.remove(cards.get(cards.size() - 1));
            return currentCard;
        }
        else
            return null;
    }
    //
    public int getQuantityCards() {
        return this.cards.size();
    }

    //Checked if deck isn't empty and remove de last card.
    public void removeCard() {
        if (!cards.isEmpty())
        this.cards.remove(this.cards.size()-1);
    }

    //This method took the last card in the deck and asked for the attributes amount.
    public int getAttributesAmount() {
        Card card = new Card();
        if (this.cards.size() != 0) {
            card = cards.get(0);
            return card.getAttributesAmount();
        }
        return 0;
    }

    public String getAttriuteName(int pos) {
        return (cards.get(pos).getName());
    }

    public void showCard(Card card) {
        System.out.println("Cantidad de Atributos: " + card.getAttributesAmount());
    }

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
    private boolean checkAttr(ArrayList<Attribute> attr, ArrayList<Attribute> attr2){
    	boolean error = false;
    	int i =0;
    	while (!(error)&& (i<attr.size())) {
    		String str = attr.get(i).getName();
    		String str2 = attr2.get(i).getName();  		
    		if (!str.equals(str2)) {
    			error=true;
    		}
    	i++;
    	}
    	return !error;
    }
    public boolean check() {
    	boolean aux=true;
    	if (cards.size()>1) {
    	    Card card = cards.get(0);
    	    int cantAttr = card.getAttributesAmount();
    	    ArrayList<Attribute> attr = card.getAttributes();
    	    int i =1;
    	    while (i<cards.size()&&(aux)){
    		    if (!((cantAttr == cards.get(i).getAttributesAmount()) &&
    				(checkAttr(attr, cards.get(i).getAttributes()))))
    			    aux = false;
    		        i++;
		        }
    	            return aux;
		        }
        else
		    return false;//el maso tiene una sola carta
    }
}