package src;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;


/**
 * Easy & simple Texas Holdem through the command-line!
 * @author Owen Moreau, Jamie Kerr, Griffin Campbell
 * @version 1.0.0
 */
public class TexasHoldem {

    public static int NUM_PLAYERS;
    public static final int CARDS_PER_PLAYER = 2;
    public static List<Player> playersInGame;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("**************************************");
        System.out.println("*      Welcome to Texas Holdem!      *");
        System.out.println("**************************************\n");

        //determine number of players
        System.out.print("Please enter the number of players: ");
        NUM_PLAYERS = in.nextInt();
        System.out.println();

        //initialize deck and shuffle it 3 times
        Deck deck = new Deck();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();

        //initialize players
        playersInGame = new LinkedList<Player>();
        for(int i = 0; i < NUM_PLAYERS + 1; i++) {
            Player p = new Player();
            if(i == 0) {
                System.out.println("  [Config] The Dealer (" + p.toString() + ") arrived at the table!");
            } else {
                System.out.println("  [Config] " + p.toString() + " arrived at the table!");
            }
            playersInGame.add(p);
        }
        System.out.println("\n");

        int numPlayersFolded = 0;
        int totalPlayers = NUM_PLAYERS;
        boolean betHasBeenMade = false;


        //deal cards one at a time "clockwise"
        for(int c = 0; c < CARDS_PER_PLAYER; c++) {
            //for every PLAYER not DEALER
            for(int i = 1; i < playersInGame.size(); i++) {
                Card newCard = deck.deal();
                System.out.println("  [Dealer] Just dealt " + newCard.toString() + " to " + playersInGame.get(i).toString());
                playersInGame.get(i).getHand().addCard(newCard);
            }
        }

        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*           Initial Round            *");
        System.out.println("**************************************\n");

        int numMove;
        int amountToRaise;
        int amountToBet;

        //check or bet phase
        if(!betHasBeenMade) {
            for(int i = 1; i < playersInGame.size(); i++) {
                if(playersInGame.get(i).isInMatch()) {
                    numMove = 0;
                    System.out.println("  " + playersInGame.get(i).toStringFull());
                    while(numMove < 1 || numMove > 2) {
                        printCheckOrBet();
                        try {
                            numMove = in.nextInt();
                        } catch(Exception e) {}
                        if(numMove == 1) {
                            //basically do nothing
                        }
                        if(numMove == 2) {
                            System.out.print("    Please enter the amount you'd like to bet: ");
                            amountToBet = in.nextInt();
                            betHasBeenMade = true;
                        }
                    }
                }
            }
            System.out.println("\n");
        }

        //each loop represents a different player's turn
        for(int i = 1; i < playersInGame.size(); i++) {
            if(playersInGame.get(i).isInMatch()) {
                numMove = 0;
                System.out.println("  " + playersInGame.get(i).toStringFull());

                while(numMove < 1 || numMove > 3) {
                    printPossibleMoves();
                    try {
                        numMove = in.nextInt();
                    } catch(Exception e) {}
                    if(numMove == 2) {
                        playersInGame.get(i).fold();
                    }
                    if(numMove == 3) {
                        System.out.print("    Please enter the amount you'd like to raise: ");
                        amountToRaise = in.nextInt();
                    }
                }
            }
            System.out.println("\n");
        }

        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*            First Round             *");
        System.out.println("**************************************\n");

        //dealer must recieve 3 cards now
        for(int i = 1; i <= 3; i++) {
            Card c = deck.deal();
            //add card to dealers hand
            System.out.println("  [Dealer] Just flipped over " + c.toString() + "!");
            playersInGame.get(0).getHand().addCard(c);
        }
        System.out.println();

        //check or bet phase
        if(!betHasBeenMade) {
            for(int i = 1; i < playersInGame.size(); i++) {
                if(playersInGame.get(i).isInMatch()) {
                    numMove = 0;
                    System.out.println("  " + playersInGame.get(i).toStringFull());
                    while(numMove < 1 || numMove > 2) {
                        printCheckOrBet();
                        try {
                            numMove = in.nextInt();
                        } catch(Exception e) {}
                        if(numMove == 1) {
                            //basically do nothing
                        }
                        if(numMove == 2) {
                            System.out.print("    Please enter the amount you'd like to bet: ");
                            amountToBet = in.nextInt();
                            betHasBeenMade = true;
                        }
                    }
                }
            }
            System.out.println("\n");
        }

        //each loop represents a different player's turn
        for(int i = 1; i < playersInGame.size(); i++) {
            if(playersInGame.get(i).isInMatch()) {
                numMove = 0;
                System.out.println("  " + playersInGame.get(i).toStringFull());

                while(numMove < 1 || numMove > 3) {
                    printPossibleMoves();
                    try {
                        numMove = in.nextInt();
                    } catch(Exception e) {}
                    if(numMove == 2) {
                        playersInGame.get(i).fold();
                    }
                    if(numMove == 3) {
                        System.out.print("    Please enter the amount you'd like to raise: ");
                        amountToRaise = in.nextInt();
                    }
                }
            }
            System.out.println("\n");
        }

        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*            Second Round            *");
        System.out.println("**************************************\n");

        //dealer must recieve 1 card now
        for(int i = 1; i <= 1; i++) {
            Card c = deck.deal();
            //add card to dealers hand
            System.out.println("  [Dealer] Just flipped over " + c.toString() + "!");
            playersInGame.get(0).getHand().addCard(c);
        }
        System.out.println();

        //check or bet phase
        if(!betHasBeenMade) {
            for(int i = 1; i < playersInGame.size(); i++) {
                if(playersInGame.get(i).isInMatch()) {
                    numMove = 0;
                    System.out.println("  " + playersInGame.get(i).toStringFull());
                    while(numMove < 1 || numMove > 2) {
                        printCheckOrBet();
                        try {
                            numMove = in.nextInt();
                        } catch(Exception e) {}
                        if(numMove == 1) {
                            //basically do nothing
                        }
                        if(numMove == 2) {
                            System.out.print("    Please enter the amount you'd like to bet: ");
                            amountToBet = in.nextInt();
                            betHasBeenMade = true;
                        }
                    }
                }

            }
            System.out.println("\n");
        }

        //each loop represents a different player's turn
        for(int i = 1; i < playersInGame.size(); i++) {
            if(playersInGame.get(i).isInMatch()) {
                numMove = 0;
                System.out.println("  " + playersInGame.get(i).toStringFull());

                while(numMove < 1 || numMove > 3) {
                    printPossibleMoves();
                    try {
                        numMove = in.nextInt();
                    } catch(Exception e) {}
                    if(numMove == 2) {
                        playersInGame.get(i).fold();
                    }
                    if(numMove == 3) {
                        System.out.print("    Please enter the amount you'd like to raise: ");
                        amountToRaise = in.nextInt();
                    }
                }
            }
            System.out.println("\n");
        }

        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*            Final Round             *");
        System.out.println("**************************************\n");

        //dealer must recieve 1 card now
        for(int i = 1; i <= 1; i++) {
            Card c = deck.deal();
            //add card to dealers hand
            System.out.println("  [Dealer] Just flipped over " + c.toString() + "!");
            playersInGame.get(0).getHand().addCard(c);
        }
        System.out.println();

        //check or bet phase
        if(!betHasBeenMade) {
            for(int i = 1; i < playersInGame.size(); i++) {
                if(playersInGame.get(i).isInMatch()) {
                    numMove = 0;
                    System.out.println("  " + playersInGame.get(i).toStringFull());
                    while(numMove < 1 || numMove > 2) {
                        printCheckOrBet();
                        try {
                            numMove = in.nextInt();
                        } catch(Exception e) {}
                        if(numMove == 1) {
                            //basically do nothing
                        }
                        if(numMove == 2) {
                            System.out.print("    Please enter the amount you'd like to bet: ");
                            amountToBet = in.nextInt();
                            betHasBeenMade = true;
                        }
                    }
                }
                System.out.println("\n");
            }
        }

        //each loop represents a different player's turn
        for(int i = 1; i < playersInGame.size(); i++) {
            if(playersInGame.get(i).isInMatch()) {
                numMove = 0;
                System.out.println("  " + playersInGame.get(i).toStringFull());

                while(numMove < 1 || numMove > 3) {
                    printPossibleMoves();
                    try {
                        numMove = in.nextInt();
                    } catch(Exception e) {}
                    if(numMove == 2) {
                        playersInGame.get(i).fold();
                    }
                    if(numMove == 3) {
                        System.out.print("    Please enter the amount you'd like to raise: ");
                        amountToRaise = in.nextInt();
                    }
                }
            }
            System.out.println("\n");
        }
        //close Scanner after user input complete
        in.close();

        System.out.println("\n");
        System.out.println("**************************************");
        System.out.println("*           Scoring Round            *");
        System.out.println("**************************************\n");

        //SCORING TIME
        Player pointerToWinner = null;

        //loop thru every non dealer player in game
        //  if currently in match
        //     calc score
        int highestScore = 0;
        for(int i = 1; i < playersInGame.size(); i++) { //loop through every player
            if(playersInGame.get(i).isInMatch()) {

                playersInGame.get(i).setScore(playersInGame.get(i).score(playersInGame.get(0).getHand())); //adds dealer's hand to determine score

                System.out.println("  [Scoring] " + playersInGame.get(i).toString() + " just scored " + playersInGame.get(i).getScore() + " points!");

                if(playersInGame.get(i).getScore() > highestScore) {
                    highestScore = playersInGame.get(i).getScore();
                }
                pointerToWinner = playersInGame.get(i);
            }
            System.out.println();
        }

        System.out.println("\n\nThank you for playing Texas Holdem!");

        System.out.println("The winner is " + pointerToWinner.toString() + " with " + pointerToWinner.getScore() + " points!");

    }//end main()

    public static void printPossibleMoves() {
        System.out.println("  POSSIBLE MOVES:   (1) Stay,  (2) Fold,  (3) Raise");
        System.out.print("    Enter the number of the move you'd like to perform: ");
    }

    public static void printCheckOrBet() {
        System.out.println("  POSSIBLE MOVES:   (1) Check,  (2) Bet");
        System.out.print("    Enter the number of the move you'd like to perform: ");
    }

}
