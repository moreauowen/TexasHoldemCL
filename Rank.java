/**
 * Represents different ranks for the Cards
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public enum Rank
{
    //  Element     Display Name    Graphic     Points      Alt Points  Priority    Alt Priority
    ACE     (   "Ace",          "A",        14,         1,         14,          1 ),
    TWO     (   "Duece",        "2",        2,          2,          2,          2 ),
    THREE   (   "Three",        "3",        3,          3,          3,          3 ),
    FOUR    (   "Four",         "4",        4,          4,          4,          4 ),
    FIVE    (   "Five",         "5",        5,          5,          5,          5 ),
    SIX     (   "Six",          "6",        6,          6,          6,          6 ),
    SEVEN   (   "Seven",        "7",        7,          7,          7,          7 ),
    EIGHT   (   "Eight",        "8",        8,          8,          8,          8 ),
    NINE    (   "Nine",         "9",        9,          9,          9,          9 ),
    TEN     (   "Ten",          "10",       10,         10,         10,         10 ),
    JACK    (   "Jack",         "J",        11,         10,         11,         10 ),
    QUEEN   (   "Queen",        "Q",        12,         10,         12,         10 ),
    KING    (   "King",         "K",        13,         10,         13,         10 ),
    JOKER   (   "Joker",        "R",        0,          0,          99,         99 );

    private final String displayName;
    private final String graphic;
    private final int points;
    private final int altPoints;
    private final int priority;
    private final int altPriority;

    private Rank( String rankDisplayName,
                  String rankGraphic,
                  int rankPoints,
                  int rankAltPoints,
                  int rankPriority,
                  int rankAltPriority )
    {
        displayName =   rankDisplayName;
        graphic =       rankGraphic;
        points =        rankPoints;
        altPoints =     rankAltPoints;
        priority =      rankPriority;
        altPriority =   rankAltPriority;
    }

    public int getAltPoints()
    {
        return altPoints;
    }

    public int getAltPriority()
    {
        return altPriority;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getGraphic()
    {
        return graphic;
    }

    public int getPoints()
    {
        return points;
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

} // end enum Rank