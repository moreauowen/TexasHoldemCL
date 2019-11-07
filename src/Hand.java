package src;

import java.util.LinkedList;

/**
 * Represents a src.Player's src.Hand
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public class Hand extends Pile
{

    public Hand()
    {
        //implicit call to super constructor instantiates the list of cards.
    }	// end constructor

    public void recieveCard(Card c) {
        super.getCards().add(c);
    }

    @Override
    public String toString()
    {
        String returnValue = "";
        LinkedList<Card> currentCards = (LinkedList<Card>)getCards();

        for(int i = 0; i < currentCards.size() - 1; i++) {
            returnValue += currentCards.get(i).toString() + ", ";
        }
        returnValue += currentCards.getLast().toString();
        return returnValue;

    }	// end toString()

    public Rank checkKind(int numOfAKind)
    {
        Card temp;
        Card high = null;
        int count = 0;
        for(int i = 0; i < super.getCards().size(); i++)
        {
            temp = super.getCards().get(i);

            for(int x = i; x < super.getCards().size(); x++)
            {
                if(super.getCards().get(x).compareTo(temp) == 0)
                    count++;

            }
            if(count >= numOfAKind)
            {
                if (high == null || temp.compareTo(high) > 0)
                    high = temp;
            }
            count = 0;
        }
        if (high == null)
            return null;
        return high.getRank();
    }

    public Rank checkTwoPair()
    {
        Card temp;
        Card high = null;
        int count = 0;
        int countPair = 0;
        for(int i = 0; i < super.getCards().size(); i++)
        {
            temp = super.getCards().get(i);

            for(int x = i; x < super.getCards().size(); x++)
            {
                if(super.getCards().get(x).compareTo(temp) == 0)
                    count++;

            }
            if(count >= 2)
            {
                if (high == null || temp.compareTo(high) > 0)
                    high = temp;
                countPair++;
                if (countPair == 2)
                    return high.getRank();
            }
            count = 0;
        }
        return null;
    }

    public Rank checkStraight()
    {
        int count = 0;
        Rank highRank = null;
        for( int i = 0; i <= 3; i++)
        {
            for ( int x = 0; x <= 5; x++)
            {

                if(super.getCards().get(i+x).getRank().getPriority()
                        - super.getCards().get(i).getRank().getAltPriority() == count ||
                        super.getCards().get(i+x).getRank().getPriority()
                                - super.getCards().get(i).getRank().getPriority() == count)
                {
                    count++;
                    if(count >= 5) {
                        highRank = super.getCards().get(i+x).getRank();
                        count = 0;
                    }
                }
                else
                {
                    count = 0;
                    break;
                }
            }
        }
        if(highRank == null)
            return null;
        return highRank;
    }

    public Rank checkStraightFlush()
    {
        int count = 0;
        Rank highRank = null;
        for( int i = 0; i <= 3; i++)
        {
            for ( int x = 0; x <= 5; x++)
            {

                if((super.getCards().get(i+x).getRank().getPriority()
                        - super.getCards().get(i).getRank().getAltPriority() == count &&
                        super.getCards().get(i+x).getSuit().getPriority() ==
                                super.getCards().get(i).getSuit().getPriority()) ||
                        (super.getCards().get(i+x).getRank().getPriority()
                                - super.getCards().get(i).getRank().getPriority() == count &&
                                super.getCards().get(i+x).getSuit().getPriority() ==
                                        super.getCards().get(i).getSuit().getPriority()))
                {
                    count++;
                    if(count >= 5) {
                        highRank = super.getCards().get(i+x).getRank();
                        count = 0;
                    }
                }
                else
                {
                    count = 0;
                    break;
                }
            }
        }
        if(highRank == null)
            return null;
        return highRank;
    }

    public Rank highestRank()
    {
        Card temp = null;
        for(int i = 0; i < super.getCards().size(); i++)
        {
            if(temp == null|| super.getCards().get(i).compareTo(temp) > 0)
                temp = super.getCards().get(i);
        }
        return temp.getRank();
    }

    public Rank checkFull()
    {
        Card temp;

        int count = 0;
        for(int i = 0; i < super.getCards().size(); i++)
        {
            temp = super.getCards().get(i);

            for(int x = i; x < super.getCards().size(); x++)
            {
                if(super.getCards().get(x).compareTo(temp) == 0)
                    count++;

            }
            if(count >= 3)
            {
                count = 0;
                if(checkFulltwo(temp))
                {
                    return temp.getRank();
                }
            }
            count = 0;
        }
        return null;

    }

    private boolean checkFulltwo(Card used)
    {
        Card temp;
        int count = 0;
        for(int i = 0; i < super.getCards().size(); i++)
        {
            temp = super.getCards().get(i);
            if(temp.equals(used))
                continue;

            for(int x = i; x < super.getCards().size(); x++)
            {
                if(super.getCards().get(x).compareTo(temp) == 0)
                    count++;

            }
            if(count >= 2)
                return true;
            count = 0;
        }
        return false;
    }

    public Rank checkFlush() {
        int count = 0;
        Suit suit;
        Rank highRank = null;
        for(int i = 0; i < super.getCards().size(); i++)
        {

            suit = super.getCards().get(i).getSuit();
            for (int x = i; x < super.getCards().size(); x++)
            {
                if(super.getCards().get(x).getSuit().compareTo(suit) == 0)
                {
                    if(highRank == null)
                    {
                        highRank = super.getCards().get(x).getRank();
                    }
                    else
                    {
                        if (super.getCards().get(x).getRank().compareTo(highRank) > 0)
                        {
                            highRank = super.getCards().get(x).getRank();
                        }
                    }
                    count++;
                }
            }
            if(count >= 5)
            {
                return highRank;
            }
            count = 0;

        }
        return null;
    }

    public boolean contains(Rank r, Suit s) {
        boolean toReturn = false;
        Card card = new Card(r,s);
        LinkedList<Card> currentHand = (LinkedList<Card>) getCards();
        for(Card c : currentHand) {
            if(c.equals(card)) {
                return true;
            }
        }
        toReturn = false;
        return toReturn;
    }

}	// end class src.Hand
