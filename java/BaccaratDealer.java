import java.util.ArrayList;
import java.util.Collections;

public class BaccaratDealer{
	ArrayList<Card> deck;
	
	public BaccaratDealer() {
		deck = new ArrayList<>();
		generateDeck();
	}
	
	public void generateDeck() {
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		for (String suit : suits) {
			for (int i = 1; i <= 13; i++) {
				deck.add(new Card(suit, i));
			}
		}
	}
	
	public ArrayList<Card> dealHand(){
		ArrayList<Card> hand = new ArrayList<>();
		
		// must draw 2 cards
		hand.add(drawOne());
		hand.add(drawOne());
		
		return hand;
	}
	
	public Card drawOne() {
		if (deckSize() == 0) {
			System.out.println("Deck is empty");
		}
		
		// remove the card that is being drawn
		return deck.remove(deckSize() - 1);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public int deckSize() {
		return deck.size();
	}
}
