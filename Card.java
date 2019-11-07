/**
 * Represents a playing card
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public class Card implements Comparable<Card>
{
    private final Rank myRank;
    private final Suit mySuit;

    public Rank getRank(){
        return myRank;
    }
    public Suit getSuit() {
        return mySuit;
    }

    public Card(Rank rank, Suit suit) {
        myRank = rank;
        mySuit = suit;
    }	// end constructor

    @Override
    public int compareTo( Card o )
    {
        if(myRank.getPriority() < o.getRank().getPriority()) {
            return -1;
        } else if (myRank.getPriority() > o.getRank().getPriority()) {
            return 1;
        } else { //if equal
            return 0;
        }


    }	// end compareTo()

    @Override
    public boolean equals( Object o )
    {
        assert o.getClass() == this.getClass();
        if(myRank.equals(((Card) o).getRank()) && mySuit.equals(((Card) o).getSuit())) {
            return true;
        } else {
            return false;
        }

    }	// end equals()

    @Override
    public String toString()
    {
        String returnValue = "";
        //add rank
        returnValue += "" + this.getRank().getDisplayName() + " of ";
        //add suit
        returnValue += "" + this.getSuit().getDisplayName();
        return returnValue;

    }	// end toString()

    private static boolean testEquals() {
        Card card1 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card2 = new Card(Rank.SEVEN, Suit.HEARTS);
        System.out.println("Now testing equals()...");
        System.out.println("  The two Cards are:");
        System.out.println("  1)  " + card1.toString());
        System.out.println("  2)  " + card2.toString());
        if(card1.equals(card2)) {
            System.out.println("  The cards match!");
            return true;
        }
        System.out.println("  The cards do not match!");
        return false;
    }
    
}	// end class Card
