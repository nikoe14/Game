import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nico on 8/30/15.
 */
public class Game {
	Deck deck;
	int playersAmount;
	Player roundWinner;
	ArrayList<Player> players;
	ArrayList<Potion> potions;
	private ArrayList<String> results;

	/**
	 * Constructor of the class.
	 *
	 * @param deck:          Deck of the game.
	 * @param playersAmount: Players of quantity.
	 */
	public Game(Deck deck, ArrayList<Potion> potions, int playersAmount) {
		this.deck = deck;
		this.potions = potions;
		this.playersAmount = playersAmount;
		this.roundWinner = null;
		this.players = new ArrayList<Player>();
		this.results = new ArrayList<String>();
		for (int i = 0; i < playersAmount; i++) {
			Deck newDeck = new Deck();
			Player newPlayer = new Player(newDeck, Integer.toString(i + 1));
			players.add(newPlayer);
		}
		dealCardsAndPotions();
	}

	/**
	 * This method will keep running until there is a winner or a final tie.
	 */
	public void play() {
		String winner;
		do {
			nextRound();
		} while (!existWinner() && (!this.players.isEmpty()));

		if (this.players.isEmpty()) {
			winner = "They tied. There are no winners.";
		} else {
			winner = "Final Winner: " + this.players.get(0).getName();
		}
		results.add(winner);
	}

	/**
	 * This method is only to return the results.
	 * This method isn't right, breaks the encapsulation of the class, but is only for return the results.
	 *
	 * @return
	 */
	public ArrayList<String> getResults() {
		return this.results;
	}

	/**
	 * Take the cards that hand, makes an index of card owners in a HashMap, and put the cards in an ArrayList cards in play.
	 * then calls other methods to choose the winning card, and give these cards to the winner.
	 */
	private void nextRound() {
		Card card;
		String result;
		ArrayList<Card> cardsInPlay = new ArrayList<>();

		if (this.roundWinner == null) {
			roundWinner = this.players.get(0);
		}

		int attributeInGame = roundWinner.selectAttribute();

		do {
			removeLosers();
			if (!existWinner() && players.size() > 0) {
				roundWinner = confrontation(attributeInGame);

				if (roundWinner != null) {
					result = "|==> Winning Player: " + roundWinner.getName() + "\n";
					result += roundWinner.getCard().toString();
				} else {
					result = "|==> They tied";
				}

				for (Player player : this.players) {
					card = player.getCard();
					if (card != null) {
						cardsInPlay.add(card);
					}
					player.removeCard();
				}
			} else return;
		} while (this.roundWinner == null);
		roundWinner.saveCards(cardsInPlay);

		results.add(result);
	}

	/**
	 * Deliver cards and potions to players.
	 */
	private void dealCardsAndPotions() {
		while (deck.getQuantityCards() >= players.size()) {
			for (int i = 0; i < players.size(); i++) {
				Random randomGenerator = new Random();
				Card newCard = deck.getCard();
				if (potions.size() > 0) {
					int randomPotion = randomGenerator.nextInt(potions.size());
					newCard.setPotion(potions.get(randomPotion));
					potions.remove(randomPotion);
				}
				players.get(i).addCard(newCard);
				deck.removeCard();
			}
		}
	}

	/**
	 * Returns true if the players' quantity is 1.
	 *
	 * @return
	 */
	private boolean existWinner() {
		return (players.size() == 1);
	}

	/**
	 * Eliminates players without cards.
	 */
	private void removeLosers() {
		for (int i = this.players.size() - 1; i >= 0; i--) {
			if (this.players.get(i).remainingCards() == 0)
				this.players.remove(this.players.get(i));
		}
	}

	/**
	 * This method faced 2 players and returns the winner.
	 * @param attributeInGame
	 * @return
	 */
	private Player confrontation(int attributeInGame) {
		Card cardPlayer1 = players.get(0).getCard();
		Card cardPlayer2 = players.get(1).getCard();
		int result = cardPlayer1.confrontation(cardPlayer2, attributeInGame);
		if (result == 1) {
			return players.get(1);
		} else if (result == -1) {
			return players.get(0);
		} else
			return null;
	}
}