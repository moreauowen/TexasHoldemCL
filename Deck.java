import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Represents a deck of playing cards
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public class Deck extends Pile
{

    /**
     * Constructs a standard 52-Card deck.
     */
    public Deck()
    {
        LinkedList<Card> deck = new LinkedList<Card>();

        //each loop is a different rank
        for(int i = 1; i <= 13; i++) {

            Rank rank = getRankFromInt(i);

            Card card1 = new Card(rank, Suit.CLUBS);
            Card card2 = new Card(rank, Suit.DIAMONDS);
            Card card3 = new Card(rank, Suit.SPADES);
            Card card4 = new Card(rank, Suit.HEARTS);

            deck.add(card1);
            deck.add(card2);
            deck.add(card3);
            deck.add(card4);

        }

        //finally, set the cards
        super.setCards(deck);

    }	// end constructor

    public static Rank getRankFromInt(int i) {
        if(i == 1) {
            return Rank.ACE;
        } else if(i == 2) {
            return Rank.TWO;
        } else if(i == 3) {
            return Rank.THREE;
        } else if(i == 4) {
            return Rank.FOUR;
        } else if(i == 5) {
            return Rank.FIVE;
        } else if(i == 6) {
            return Rank.SIX;
        } else if(i == 7) {
            return Rank.SEVEN;
        } else if(i == 8) {
            return Rank.EIGHT;
        } else if(i == 9) {
            return Rank.NINE;
        } else if(i == 10) {
            return Rank.TEN;
        } else if(i == 11) {
            return Rank.JACK;
        } else if(i == 12) {
            return Rank.QUEEN;
        } else {
            return Rank.KING;
        }
    }

    public Card deal() {
        Card leavingDeck = ((LinkedList<Card>) super.getCards()).pop();
        return leavingDeck;
    }

}	// end class Deck
