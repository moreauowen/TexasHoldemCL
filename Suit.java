/**
 * Represents different suits for the Cards
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public enum Suit implements Comparable<Suit>
{
    //  Element         Display Name    Graphic     Color      Priority
    NONE        (   "",             "",         "",         0 ),
    CLUBS       (   "Clubs",        "♣",        "black",    1 ),
    DIAMONDS    (   "Diamonds",     "♦",        "red",      3 ),
    HEARTS      (   "Hearts",       "♥",        "red",      2 ),
    SPADES      (   "Spades",       "♠",        "black",    4 );

    private final String displayName;
    private final String graphic;
    private final String color;
    private final int priority;

    private Suit( String suitDisplayName,
                  String suitGraphic,
                  String suitColor,
                  int suitPriority )
    {
        displayName =   suitDisplayName;
        graphic =       suitGraphic;
        color =         suitColor;
        priority =      suitPriority;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getGraphic()
    {
        return graphic;
    }

    public String getColor()
    {
        return color;
    }

    public int getPriority()
    {
        return priority;
    }

    @Override
    public String toString()
    {
        return graphic ;
    }

} // end enum Suit