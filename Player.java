import java.util.Collections;

/**
 * Represents each Player in the game.
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public class Player
{
    //id is global to allow differentiation of Players
    public static int id = 0;

    private int specId;
    private Hand hand ;
    private String playerName;
    private int numCoins;
    private int score;
    private boolean inMatch;

    public void fold() {
        inMatch = false;
    }

    public int getSpecId() {
        return specId;
    }

    public void setSpecId(int specId) {
        this.specId = specId;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getNumCoins() {
        return numCoins;
    }

    public void setNumCoins(int numCoins) {
        this.numCoins = numCoins;
    }

    public String toString() {
        String returnValue = "";
        returnValue += getPlayerName();
        return returnValue;
    }

    public String toStringFull() {
        String returnValue = "";
        returnValue += getPlayerName() + " with the cards: ";
        returnValue += getHand().toString();
        return returnValue;
    }

    /**
     * No args constructor for type Player
     */
    public Player()
    {
        specId = id++;
        hand = new Hand();
        playerName = "Player " + specId;
        numCoins = 0;
        setScore(0);
        setInMatch(true);
    }	// end constructor

    /**
     * Single arg constructor to define specific name for Player
     */
    public Player(String name)
    {
        specId = id++;
        hand = new Hand();
        playerName = name;
        numCoins = 0;
        setScore(0);
        setInMatch(true);
    }	// end constructor

    /**
     * No args constructor for type Player
     */
    public Player(String name, int startingCoins)
    {
        specId = id++;
        hand = new Hand();
        playerName = name;
        numCoins = startingCoins;
        setScore(0);
        setInMatch(true);
    }	// end constructor

    public int score(Hand dealer)
    {
        for(int i = 0; i < dealer.getCards().size(); i++) {

            hand.addCard(dealer.getCards().get(i));
        }
        Collections.sort(hand.getCards());
        System.out.println("  [Dealer] Calculating score for " + this.toString());
        System.out.println("  Cards: " + hand.toString());
        System.out.print("  You had a ");

        if ((hand.contains(Rank.ACE, Suit.CLUBS) && hand.contains(Rank.KING, Suit.CLUBS) &&
                hand.contains(Rank.QUEEN, Suit.CLUBS) && hand.contains(Rank.JACK, Suit.CLUBS) &&
                hand.contains(Rank.TEN, Suit.CLUBS)) ||
                (hand.contains(Rank.ACE, Suit.SPADES) && hand.contains(Rank.KING, Suit.SPADES) &&
                        hand.contains(Rank.QUEEN, Suit.SPADES) && hand.contains(Rank.JACK, Suit.SPADES) &&
                        hand.contains(Rank.TEN, Suit.SPADES)) ||
                (hand.contains(Rank.ACE, Suit.HEARTS) && hand.contains(Rank.KING, Suit.HEARTS) &&
                        hand.contains(Rank.QUEEN, Suit.HEARTS) && hand.contains(Rank.JACK, Suit.HEARTS) &&
                        hand.contains(Rank.TEN, Suit.HEARTS)) ||
                (hand.contains(Rank.ACE, Suit.DIAMONDS) && hand.contains(Rank.KING, Suit.DIAMONDS) &&
                        hand.contains(Rank.QUEEN, Suit.DIAMONDS) && hand.contains(Rank.JACK, Suit.DIAMONDS) &&
                        hand.contains(Rank.TEN, Suit.DIAMONDS)))
        {
            System.out.println("--ROYAL FLUSH--");
            return 150;
        }
        else if (hand.checkKind(4) != null )
        {
            Rank rank = hand.checkKind(4);

            System.out.println("Four of a Kind: " + rank.toString());
            return 105 + rank.getPoints();

        }
        else if (hand.checkFull() != null)
        {
            Rank rank = hand.checkFull();

            System.out.println("Full House: " + rank.toString());
            return 90 + rank.getPoints();

        }
        else if (hand.checkFlush() != null)
        {
            Rank rank = hand.checkFlush();

            System.out.println("Flush: " + rank.toString());
            return 75 + rank.getPoints();

        }
        //else if ( Straight )
        //return 60 + rank.getPoints();
        else if (hand.checkKind(3) != null)
        {
            Rank rank = hand.checkKind(3);

            System.out.println("Three of a Kind: " + rank.toString());
            return 45 + rank.getPoints();

        }
        else if (hand.checkTwoPair() != null)
        {
            Rank rank = hand.checkTwoPair();

            System.out.println("Two Pair: " + rank.toString());
            return 30 + rank.getPoints();

        }
        else if (hand.checkKind(2) != null)
        {
            Rank rank = hand.checkKind(2);

            System.out.println("Pair: " + rank.toString());
            return 15 + rank.getPoints();

        }
        else
        {
            Rank rank = hand.highestRank();

            System.out.println("High Card: " + rank.toString());
            return rank.getPoints();

        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isInMatch() {
        return inMatch;
    }

    public void setInMatch(boolean inMatch) {
        this.inMatch = inMatch;
    }

}	// end class Player
