import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;
public class DiceGameViewer extends JFrame{
    // Instance Variables
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;
    // Data sharing variable
    private DiceGame gameInfo;

    // Constructor
    public DiceGameViewer(DiceGame gameInfo){
        // Initialize data sharing
        this.gameInfo = gameInfo;
        // Initialize window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }
    // Main paint function. Uses conditionals and the gameState to print different game screens
    public void paint(Graphics g) {
        // Covers up any previous graphics
        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.black);
        // Runs the appropriate paint function for each gameState
        if(gameInfo.getGameState() == 0) {
            paintState0(g);
        }
        if(gameInfo.getGameState() == 1){
            paintState1(g);
        }
        if(gameInfo.getGameState() == 2){
            paintState2(g);
        }
        if(gameInfo.getGameState() == 3){
            paintState3(g);
        }
        if(gameInfo.getGameState() == 4){
            paintState4(g);
        }
        if(gameInfo.getGameState() == 5){
            paintState5(g);
        }
        if(gameInfo.getGameState() == 6){
            paintState6(g);
        }
        if(gameInfo.getGameState() == 7){
            paintState7(g);
        }
        if(gameInfo.getGameState() == 8){
            paintState8(g);
        }
        if(gameInfo.getGameState() == 1000){
            paintState1000(g);
        }
    }

    // Instructions state
    public void paintState0(Graphics g){
        // Set the font size
        g.setFont(new Font("Serif", Font.PLAIN, 10));
        // Draw the instructions
        g.drawString("Welcome to Knockout! This is a fast dice game that can ", 100, 130);
        g.drawString("be played with two people. At the beginning of the game,", 100, 150);
        g.drawString("each user is prompted for their name and a knockout number.", 100, 170);
        g.drawString("When entering this information, please type your name, hit", 100, 190);
        g.drawString("the return key, type your knockout number, and then hit the ", 100, 210);
        g.drawString("return key again. Once both players have provided their name ", 100, 230);
        g.drawString("and knockout number, the game begins! Each turn, each player ", 100, 250);
        g.drawString("takes turns rolling their die twice. If the sum of their two", 100, 270);
        g.drawString("rolls add up to their knockout number, they are knocked out! ", 100, 290);
        g.drawString("This adds a game to their opponents win count, before the", 100, 310);
        g.drawString("users are asked if they would like to play another round. ", 100, 330);
        g.drawString("Once the users have decided to end the game, the console ", 100, 350);
        g.drawString("will print out the winner and their win count!", 100,  370);
    }

    // Player one enter information state
    public void paintState1(Graphics g){
        paintState0(g);
        g.drawString("Player one, please enter your name, and then your knockout", 100, 400);
        g.drawString("number. It must be between 6 and 8, inclusive.", 100, 420);
    }

    // Player two enter information state
    public void paintState2(Graphics g){
        paintState0(g);
        g.drawString("Player two, please enter your name, and then your knockout", 100, 400);
        g.drawString("number. It must be between 6 and 8, inclusive.", 100, 420);
    }

    // Ready for players to roll state
    public void paintState3(Graphics g){
        paintTable(g);
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.setColor(Color.black);
        if(gameInfo.getPlayerTurn() == 1){
            g.drawString(gameInfo.getP1().getName() + ". Would you like to roll?", 125, 50);
        }
        if(gameInfo.getPlayerTurn() == 2){
            g.drawString(gameInfo.getP2().getName() + ". Would you like to roll?", 125, 50);
        }
    }
    // Dice has been rolled state
    public void paintState4(Graphics g){
        g.setColor(Color.black);
        paintState3(g);
        paintDice(g);
    }
    // One player is knocked out state
    public void paintState5(Graphics g){
        // Still paint the board and dice
        paintState4(g);
        // Set new font & color
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.setColor(Color.red);
        // Print the player who is knocked out
        if(gameInfo.getPlayerTurn() == 1) {
            g.drawString("Oops! Player one is knocked out!", 110, 75);
        }
        if(gameInfo.getPlayerTurn() == 2){
            g.drawString("Oops! Player two is knocked out!", 110, 75);
        }
        // Ask the user if they would like to keep playing
        g.drawString("Would you like to play another round?", 105, 105);
    }
    // Player one wins state
    public void paintState6(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString(gameInfo.getP1().getName() + " wins!", 100, 250);
    }
    // Player two wins state
    public void paintState7(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString(gameInfo.getP2().getName() +" wins!", 100, 250);
    }
    // The game ends in a tie state
    public void paintState8(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("This game ended in a draw!", 500, 250);
    }
    // Waiting for next turn state
    public void paintState1000(Graphics g){
        paintTable(g);
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.setColor(Color.black);
        g.drawString("Would you like to proceed?", 135, 50);
    }
    // Paints the entire table, players, and their corrosponding information
    public void paintTable(Graphics g){
        // Drawing the table and players themselves
        g.setColor(new Color(222,184,135));
        g.fillRect(100, 0, 300, 500);
        g.setColor(new Color(0, 151, 255));
        g.fillOval(50, 190, 100, 30);
        g.fillOval(50, 280, 100, 30);
        g.setColor(new Color(255, 49, 49));
        g.fillOval(350, 190, 100, 30);
        g.fillOval(350, 280, 100, 30);
        g.setColor(new Color(217, 130, 96));
        g.fillOval(10,200, 100, 100);
        g.fillOval(390, 200, 100, 100);
        // Print player names
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 20));
        g.drawString(gameInfo.getP1().getName(), 20, 100);
        g.drawString(gameInfo.getP2().getName(), 420, 100);
        g.setFont(new Font("Serif", Font.PLAIN, 10));
        // Print each player's knockout number
        g.drawString("KO number: " + Integer.toString(gameInfo.getP1().getNum()), 20, 170);
        g.drawString("KO number: " + Integer.toString(gameInfo.getP2().getNum()), 420, 170);
        // Print each player's score
        g.drawString("Score: " + Integer.toString(gameInfo.getP1().getWins()), 30, 400);
        g.drawString("Score: " + Integer.toString(gameInfo.getP2().getWins()), 420, 400);
        // Draw the turn indicator
        paintIndicator(g);
    }
    // Paints turn indicator
    public void paintIndicator(Graphics g){
        // Create and orange triangle depending on the player whose turn in is
        g.setColor(Color.orange);
        int[] yPoints = {350, 330, 350};
        int[] xPoints = new int[3];
        // Player one's turn
        if(gameInfo.getPlayerTurn() == 1){
            xPoints[0] = 40;
            xPoints[1] = 60;
            xPoints[2] = 80;
        }
        // Player two's turn
        if(gameInfo.getPlayerTurn() == 2){
            xPoints[0] = 500-40;
            xPoints[1] = 500-60;
            xPoints[2] = 500-80;
        }
        // Draw the triangle
        g.fillPolygon(xPoints, yPoints, 3);
    }

    // Paints both dice using the draw function in the Die class
    public void paintDice(Graphics g){
        gameInfo.getD1().draw(g);
        gameInfo.getD2().draw(g);
    }



}
