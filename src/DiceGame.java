import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DiceGame {
    // Instance variables
    private DiceGameViewer window;
    private Die d1, d2;
    private int p1Sum;
    private int p2Sum;
    private Player p1, p2;
    private String winner;
    private int gameState;
    private int playerTurn;

    // Constructor
    public DiceGame(){
        // Initialize gameState
        gameState = 0;
        // Initialize PlayerTurn
        playerTurn = 1;
        // Create two dice to be used in the game
        d1 = new Die(6, window);
        d2 = new Die(6, window);
        // Create the front end object
        window = new DiceGameViewer(this);
    }

    public void run() {
        // Print instructions to the console
        System.out.println("Welcome to Knockout! This is a fast dice game that can be played with two people. At the beginning of the game, each user is prompted for their name and a knockout number. When entering this information, please type your name, hit the return key, type your knockout number, and then hit the return key again. Once both players have provided their name and knockout number, the game begins! Each turn, each player takes turns rolling their die twice. If the sum of their two rolls add up to their knockout number, they are knocked out! This adds a game to their opponents win count, before the users are asked if they would like to play another round. Once the users have decided to end the game, the console will print out the winner and their win count!");
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);

        // Set to the first state of the game: collecting name and knockout number for P1
        gameState = 1;
        window.repaint();
        // Take user input to set the name of each player, and their knockout number
        System.out.println("Player one, please enter your name, and then your knockout number. Your knockout number must be between " + d1.getSides() + " and " + (d1.getSides() + 2) + ", inclusive:");
        p1 = new Player(input.nextLine(), input.nextInt());
        input.nextLine();

        // State 2: collecting name and knockout number of P2
        gameState = 2;
        window.repaint();
        System.out.println("Thank you! Player two, please enter your name and then your knockout number. It must follow the same criteria as " + p1.getName() + "'s knockout number:");
        p2 = new Player(input.nextLine(), input.nextInt());
        input.nextLine();

        // Main game logic loop
        do {
            // Loop for each round
            do {
                // Set to player 1's turn
                playerTurn = 1;
                // Game state 3: ready to begin playing
                gameState = 3;
                window.repaint();
                // Ask the user if they would like to roll
                do {
                    System.out.println(p1.getName() + ", would you like to roll?(y/n)");
                } while (!(input.nextLine().equals("y")));
                // Game state 4: Player one rolls
                gameState = 4;
                // Find the sum of the dice rolled
                p1Sum = d1.roll() + d2.roll();
                // Tell the user their roll
                System.out.println(p1.getName() + " rolled " + p1Sum + "!");
                window.repaint();
                // If the number matches player one's knockout number, let the player know and give player two a point
                if (p1Sum == p1.getNum()) {
                    System.out.println("Oops! Player one is knocked out!");
                    p2.addWin();
                    // Game state 5: a player loses a round
                    gameState = 5;
                    break;
                }
                // Set to player two's turn
                playerTurn = 2;
                // Ask player two if they would like to roll
                do {
                    System.out.println(p2.getName() + ", would you like to roll?(y/n)");
                } while (!(input.nextLine().equals("y")));
                // Get the sum of the dice rolls
                p2Sum = d1.roll() + d2.roll();
                // Tell the user their roll
                System.out.println(p2.getName() + " rolled " + p2Sum + " !");
                window.repaint();
                // If the sum equals player two's knockout number, let them know and give player one a point.
                if (p2Sum == p2.getNum()) {
                    System.out.println("Oops! Player two is knocked out!");
                    p1.addWin();
                    // Game state 5: a player loses a round
                    gameState = 5;
                    break;
                }
                // Allow time for repaint function to execute and for players to see roll outcome
                wait(1000);
                // Game state 1000: One turn is over, ask the players if they are ready to proceed
                gameState = 1000;
                window.repaint();
                wait(250);
                do {
                    System.out.println("Would you like to proceed?(y/n)");
                } while (!(input.nextLine().equals("y")));
            } while (true);
            // Continuation of state 5. Ask the users if they would like to proceed to the next round
            System.out.println("Would you like to play another round?(y/n)");
            if (!(input.nextLine().equals("y"))) {
                break;
            } else {
                System.out.println("Awesome!");
            }
        } while (true);
        // Once the players have decided to stop, the scores are assessed
        // Case if player one wins
        if (p1.getWins() > p2.getWins()) {
            gameState = 6;
            System.out.println(p1.getName() + " wins, with " + p1.getWins() + " total rounds won!");
        }
        // Case if player two wins
        else if (p2.getWins() > p1.getWins()) {
            gameState = 7;
            System.out.println(p2.getName() + " wins, with " + p2.getWins() + " total rounds won!");
        }
        // Case if there is a tie
        else {
            gameState = 8;
            System.out.println("This game ended in a draw. Each player had " + p1.getWins() + " total wins!");
        }
        window.repaint();
    }

    // Getters and setters for instance variables
    public Die getD1() {
        return d1;
    }

    public Die getD2() {
        return d2;
    }

    public int getGameState() {
        return gameState;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    // Wait method. Used to give time for the front end thread to catch up the back end, and used to give players time to get information from certain game states
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create a DiceGame object and run the game loop
        DiceGame g1 = new DiceGame();
        g1.run();
    }
}