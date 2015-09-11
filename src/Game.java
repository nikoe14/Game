import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nico on 8/30/15.
 */
public class Game {
	Deck deck;
    String result = "";
	int playersAmount;
	int runWinner = 0;
	ArrayList<Deck> decksPlayers = new ArrayList<Deck>();
	ArrayList<Player> players = new ArrayList<Player>();
	HashMap<Card, Player> cardsOwners = new HashMap<Card, Player>();
    private ArrayList<String> results = new ArrayList<String>();

	public Game(Deck deck, int playersAmount) {
		this.deck = deck;
		this.playersAmount = playersAmount;
		this.runWinner = 0;
		for (int i = 0; i < playersAmount; i++) {
			Deck newDeck = new Deck();
			decksPlayers.add(newDeck);
			Player newPlayer = new Player(decksPlayers.get(i), Integer.toString(i));
			players.add(newPlayer);
		}
		dealCards();
	}

	public void play() {
		do {
			removeLosers(); //In each round, eliminates players without cards.
			nextRound();
		} while(!existWinner() && players.size() > 0);
		if(existWinner()){
			System.out.println("Gano el jugador: " + players.get(0).getName());
            results.add("========== The winner was the Player " + players.get(0).getName() +" ==========");
		}
	}

    public ArrayList<String> Results() {
        return this.results;
    }

	private void nextRound() {
		if (!existWinner() && players.size() > 0) {
		    Card card;
		    ArrayList<Card> cardsInPlay = new ArrayList<>();
		    int attributeInGame = players.get(runWinner).selectAttribute();
			System.out.println("Atributo en Juego: " + attributeInGame);
            //cardsOwners.clear();
		    for (Player player : players) {
			    card = player.getCard();
			    cardsOwners.put(card, player);
			    cardsInPlay.add(card);
		    }
            Card winCard = winCard(cardsInPlay, attributeInGame);
		    selectWinner(winCard, attributeInGame, cardsInPlay, null);
	    }
        results.add(result);
	}


	private void selectWinner(Card winCard, int attributeInGame, ArrayList<Card> cardsInPlay, ArrayList<Card> reward) {
		if (winCard == null) {
            results.add("|==> There was a tie.");
			tiebreaker(attributeInGame,cardsInPlay);
		}
		else 
		{
			Player playerWin = cardsOwners.get(winCard);
            result = "|==> Winning Player: " + playerWin.getName() + " |==> Winning Card: "+ winCard.getName() +" |==> Winning Attribute: " + winCard.getAttributesName(attributeInGame) +" |==> Attribute Value: " + winCard.getAttribute(attributeInGame);
            System.out.println("Jugador que gano la ronda: " + playerWin.getName());
			runWinner = players.indexOf(playerWin);
			saveCards(cardsInPlay);
            if (reward != null) {
                saveCards(reward);
                results.add("|==> Winning Player: ");
            }
		}
	}

	private void saveCards(ArrayList<Card> cardsInPlay) {
        for (Card card : cardsInPlay) {
            players.get(runWinner).addCard(card);
        }
	}

	private void tiebreaker(int attributeInGame, ArrayList<Card> cardsInPlay) {
		removeLosers();
		if(!existWinner() && players.size() > 0) {
			ArrayList<Card> cardsInTie = cardsInPlay;
			cardsInPlay.clear();
			Card card;
			for (Player player : players) {
				card = player.getCard();
				cardsOwners.put(card,player);
				cardsInPlay.add(card);
			}
			Card winCard = winCard(cardsInPlay, attributeInGame);
            selectWinner(winCard, attributeInGame, cardsInTie, cardsInPlay);
		} else {
            results.add("|==> There was a final tie.");
		}
	}

	private void dealCards() {
		while (deck.getQuantityCards() >= players.size()) {
			for (int i = 0; i < players.size() ; i++) {
				players.get(i).addCard(deck.getCard());
			}
		}
	}

	private boolean existWinner() {
        return (players.size() == 1);
	}

	private Card winCard(ArrayList<Card> cardInPlay, int attributeInGame) {
		int attributeCard1 = cardInPlay.get(0).getAttribute(attributeInGame);
		int attributeCard2 = cardInPlay.get(1).getAttribute(attributeInGame);

        if (attributeCard1 > attributeCard2)
            return cardInPlay.get(0);
        else
            if (attributeCard2 > attributeCard1)
                return cardInPlay.get(1);
        else
                return null;
    }

	private void removeLosers() {
		for (int i = this.players.size()-1; i >= 0; i--) {
			if (this.players.get(i).remainingCards() == 0)
				this.players.remove(this.players.get(i));
		}
	}
}
