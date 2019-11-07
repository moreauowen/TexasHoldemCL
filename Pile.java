import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List ;

/**
 * Represents a pile of playing cards (used in Hand and Deck).
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public class Pile
{
    private List<Card> cards ;

    public List<Card> getList(){
        return getCards();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    /**
     * Constructor is just used to instantiate list of cards
     */
    public Pile(){
        setCards(new LinkedList<Card>());
    }	// end constructor

    /**
     * THIS IS TO BE USED WHEN INSTANTIATING A DECK
     * Adds a card to the Pile.
     * @param c
     */
    public void addCard(Card c) {
        getCards().add(c);
    }

    public void clear() {
        setCards(new LinkedList<Card>());
    }

    /**
     * Used to determine if list of Cards is empty or not.
     * @return true if empty, else false
     */
    public boolean isEmpty() {
        return cards.size() == 0;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return null ;

    }	// end toString()

    public void shuffle() {
        Collections.shuffle(cards);
    }

}	// end class Pile
