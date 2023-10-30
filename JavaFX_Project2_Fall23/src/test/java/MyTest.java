import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyTest {

	 @Test
	    public void testWhoWon_PlayerWins() { //1
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> playerHand = new ArrayList<>();
	        playerHand.add(new Card("Diamonds", 2));
	        ArrayList<Card> bankerHand = new ArrayList<>();
	        bankerHand.add(new Card("Hearts", 1));
	        assertEquals("Player", logic.whoWon(playerHand, bankerHand));
	    }

	 @Test
	    public void testWhoWon_BankerWins() { //2
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> playerHand = new ArrayList<>();
	        playerHand.add(new Card("Clubs", 8));
	        ArrayList<Card> bankerHand = new ArrayList<>();
	        bankerHand.add(new Card("Spades", 9));
	        assertEquals("Banker", logic.whoWon(playerHand, bankerHand));
	    }

	    @Test
	    public void testHandTotal_NormalValues() { //3
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card("Hearts", 7));
	        hand.add(new Card("Spades", 3));
	        assertEquals(0, logic.handTotal(hand));
	    }

	    @Test
	    public void testHandTotal_FaceCards() { //4
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card("Diamonds", 11));
	        hand.add(new Card("Clubs", 12));
	        assertEquals(0, logic.handTotal(hand));
	    }

	    @Test
	    public void testEvaluateBankerDraw_Under7() { //5 
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card("Spades", 6));
	        Card playerCard = new Card("Hearts", 4);
	        assertEquals(true, logic.evaluateBankerDraw(hand, playerCard));
	    }

	    @Test
	    public void testEvaluateBankerDraw_7() { //6 
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card("Diamonds", 2));
	        Card playerCard = new Card("Clubs", 5);
	        assertEquals(false, logic.evaluateBankerDraw(hand, playerCard));
	    }

	    @Test
	    public void testEvaluatePlayerDraw_Under6() { //7 
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card("Hearts", 4));
	        assertEquals(true, logic.evaluatePlayerDraw(hand));
	    }

	    @Test
	    public void testEvaluatePlayerDraw_6() { //8 
	        BaccaratGameLogic logic = new BaccaratGameLogic();
	        ArrayList<Card> hand = new ArrayList<>();
	        hand.add(new Card("Spades", 6));
	        assertEquals(false, logic.evaluatePlayerDraw(hand));
	    }

	    // Test cases Start here for the BaccaratDealer

	        @Test
	        public void testGenerateDeck() { //9
	            BaccaratDealer dealer = new BaccaratDealer();
	            dealer.generateDeck();
	            assertEquals(52, dealer.deckSize());
	        }

	        @Test
	        public void testDealHand() { //10
	            BaccaratDealer dealer = new BaccaratDealer();
	            ArrayList<Card> hand = dealer.dealHand();
	            assertEquals(2, hand.size());
	            assertEquals(dealer.deckSize(), 50); // Deck size should be reduced by 2
	        }

	        @Test
	        public void testDrawOne() { //11
	            BaccaratDealer dealer = new BaccaratDealer();
	            Card drawnCard = dealer.drawOne();
	            assertEquals(1, dealer.deckSize()); // Deck size should be reduced by 1
	        }

	        @Test
	        public void testShuffleDeck() { //12
	            BaccaratDealer dealer = new BaccaratDealer();
	            ArrayList<Card> originalDeck = new ArrayList<>(dealer.deck);
	            dealer.shuffleDeck();
	            ArrayList<Card> shuffledDeck = dealer.deck;
	            // Assert that at least one card is in a different position
	            boolean cardsMoved = false;
	            for (int i = 0; i < originalDeck.size(); i++) {
	                if (!originalDeck.get(i).equals(shuffledDeck.get(i))) {
	                    cardsMoved = true;
	                    break;
	                }
	            }
	            assertEquals(true, cardsMoved);
	        }

	        @Test
	        public void testDeckSize() { //13
	            BaccaratDealer dealer = new BaccaratDealer();
	            int initialSize = dealer.deckSize();
	            dealer.dealHand(); // Deal a hand to reduce the deck size
	            int newSize = dealer.deckSize();
	            assertEquals(initialSize - 2, newSize);
	        }
	        
	        // BaccaratGameLogic Test cases under here 
	        
	        @Test
	        public void testWhoWon_PlayerWins1() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> playerHand = new ArrayList<>();
	            playerHand.add(new Card("Hearts", 7));
	            playerHand.add(new Card("Diamonds", 8));
	            ArrayList<Card> bankerHand = new ArrayList<>();
	            bankerHand.add(new Card("Clubs", 6));
	            bankerHand.add(new Card("Spades", 3));
	            assertEquals("Player", logic.whoWon(playerHand, bankerHand));
	        }

	        @Test
	        public void testWhoWon_BankerWins1() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> playerHand = new ArrayList<>();
	            playerHand.add(new Card("Diamonds", 9));
	            playerHand.add(new Card("Hearts", 2));
	            ArrayList<Card> bankerHand = new ArrayList<>();
	            bankerHand.add(new Card("Clubs", 8));
	            bankerHand.add(new Card("Spades", 7));
	            assertEquals("Banker", logic.whoWon(playerHand, bankerHand));
	        }

	        @Test
	        public void testHandTotal_NormalValues1() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> hand = new ArrayList<>();
	            hand.add(new Card("Hearts", 7));
	            hand.add(new Card("Diamonds", 8));
	            assertEquals(5, logic.handTotal(hand));
	        }

	        @Test
	        public void testHandTotal_FaceCards1() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> hand = new ArrayList<>();
	            hand.add(new Card("Spades", 11));
	            hand.add(new Card("Clubs", 12));
	            assertEquals(0, logic.handTotal(hand));
	        }

	        @Test
	        public void testEvaluateBankerDraw_Under71() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> hand = new ArrayList<>();
	            hand.add(new Card("Hearts", 3));
	            Card playerCard = new Card("Diamonds", 4);
	            assertEquals(true, logic.evaluateBankerDraw(hand, playerCard));
	        }

	        @Test
	        public void testEvaluateBankerDraw_71() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> hand = new ArrayList<>();
	            hand.add(new Card("Spades", 6));
	            Card playerCard = new Card("Clubs", 1);
	            assertEquals(false, logic.evaluateBankerDraw(hand, playerCard));
	        }

	        @Test
	        public void testEvaluatePlayerDraw_Under61() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> hand = new ArrayList<>();
	            hand.add(new Card("Diamonds", 4));
	            assertEquals(true, logic.evaluatePlayerDraw(hand));
	        }

	        @Test
	        public void testEvaluatePlayerDraw_61() {
	            BaccaratGameLogic logic = new BaccaratGameLogic();
	            ArrayList<Card> hand = new ArrayList<>();
	            hand.add(new Card("Clubs", 6));
	            assertEquals(false, logic.evaluatePlayerDraw(hand));
	        }
}
