import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nico on 8/30/15.
 */
public class Game {
	Deck deck;
	int playersAmount;
	int runWinner = 0;
	ArrayList<Deck> decksPlayers = new ArrayList<Deck>();
	ArrayList<Player> players = new ArrayList<Player>();
	HashMap<Card, Player> cardsOwners = new HashMap<Card, Player>();

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
		} while(!existWinner(   ));

		if(existWinner()){
			System.out.println("Gano el jugador: " + players.get(0).getName());
		}
	}

	private void nextRound() {
        //System.out.println("========================================================================");
        //System.out.println("====Cartas antes de la ronda");
        //System.out.println("Cantidad de Cartas del jugador 0: "+ players.get(0).remainingCards());
        //System.out.println("Cantidad de Cartas del jugador 1: "+ players.get(1).remainingCards());
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

            //System.out.println("====Cartas cuando termina la ronda");
            //System.out.println("Cantidad de Cartas del jugador 0: "+ players.get(0).remainingCards());
            //System.out.println("Cantidad de Cartas del jugador 1: " + players.get(1).remainingCards());
		    selectWinner(winCard, attributeInGame, cardsInPlay, null);
	    }
	}


	private void selectWinner(Card winCard, int attributeInGame, ArrayList<Card> cardsInPlay, ArrayList<Card> reward) {
		if (winCard == null) {
			tiebreaker(attributeInGame,cardsInPlay);
		}
		else 
		{
			Player playerWin = cardsOwners.get(winCard);
            System.out.println("Jugador que gano la ronda: " + playerWin.getName());
			runWinner = players.indexOf(playerWin);
			saveCards(cardsInPlay);
            if (reward != null)
                saveCards(reward);
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
            System.out.println("Empataron");
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
		int pos = 0;
		//System.out.println("Cartas en Juego: " + cardInPlay.size());
		//System.out.println("card 1: "+ cardInPlay.get(pos).getName()  +", Atributo en juego: "+ cardInPlay.get(pos).getAttributesName(attributeInGame)  + ", Valor: "+ cardInPlay.get(pos).getAttribute(attributeInGame) +" Owner, Player: "+ cardsOwners.get(cardInPlay.get(pos)).getName() + " Cantidad de Atributos de la carta: " +cardInPlay.get(pos).getAttributesAmount());
        //System.out.println("card 2: "+ cardInPlay.get(1).getName()  +", Atributo en juego: "+ cardInPlay.get(1).getAttributesName(attributeInGame)  + ", Valor: "+ cardInPlay.get(1).getAttribute(attributeInGame) +" Owner, Player: "+ cardsOwners.get(cardInPlay.get(1)).getName() + " Cantidad de Atributos de la carta: " +cardInPlay.get(1).getAttributesAmount());
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
		int max = this.players.size()-1;
		for (int i = max; i >= 0; i--) {
			if (this.players.get(i).remainingCards() == 0) {
				this.players.remove(this.players.get(i));
			}
		}
	}
}
