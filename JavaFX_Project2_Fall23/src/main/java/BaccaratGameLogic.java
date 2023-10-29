import java.util.ArrayList;

public class BaccaratGameLogic {
	
	public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2) {
		int playerTotal = handTotal(hand1);
		int dealerTotal = handTotal(hand2);
		
		if (playerTotal > dealerTotal) {
			return "Player";
		} else if (playerTotal < dealerTotal) {
			return "Banker";
		} else {
			return "Draw";
		}
	}
	
	public int handTotal(ArrayList<Card> hand) {
		int total = 0;
		
		for (Card card : hand) {
			int handValue = card.value;
			
			if (handValue > 9) {
				handValue = 0; // A card cannot have a higher value than 9 (face cards and 10 = 0)
			}
			
			total += handValue;
		}
		
		return total % 10; // keep the cards values between 0 and 9
	}
	
	public boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard) {
		int total = handTotal(hand);
		
		if (total < 7) {
			return true;
		} else if (total == 7) {
			return false;
		} else {
			return false;
		}
	}
	
	public boolean evaluatePlayerDraw(ArrayList<Card> hand) {
		int total = handTotal(hand);
		
		if (total < 6) {
			return true;
		} else if (total == 6) {
			return false;
		} else {
			return false;
		}
	}
	
}