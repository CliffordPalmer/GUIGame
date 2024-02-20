import javax.swing.*;
import java.awt.*;
public class Die
{
    // Instance variables
    private int numSides;
    // Dice images
    private Image[] dice;
    private DiceGameViewer window;
    int roll;
    // Constructor which takes in number of sides and a front end
    public Die(int numSides, DiceGameViewer window) {
        // Initialize number of sides
        this.numSides = numSides;
        // Initialize dice images
        dice = new Image[6];
        dice[0] = new ImageIcon("Resources/dice-six-faces-one.png").getImage();
        dice[1] = new ImageIcon("Resources/dice-six-faces-two.png").getImage();
        dice[2] = new ImageIcon("Resources/dice-six-faces-three.png").getImage();
        dice[3] = new ImageIcon("Resources/dice-six-faces-four.png").getImage();
        dice[4] = new ImageIcon("Resources/dice-six-faces-five.png").getImage();
        dice[5] = new ImageIcon("Resources/dice-six-faces-six.png").getImage();
        // Intialize window
        this.window = window;
    }
    // Default constructor
    public Die() {
        numSides = 6;
    }

    // Getter for numSides
    public int getSides() {
        return numSides;
    }

    // Returns a random int to simulate a dice roll
    public int roll() {

        roll = (int)(Math.random() * (numSides) + 1);

        return roll;
    }

    // toString method
    public String toString() {
        return "You are using a " + numSides + "-sided die.";
    }

    // Draw function
    public void draw(Graphics g){
        // Draws a Die with the correct image based on the dice roll. Draws it at a random position on the table
        g.drawImage(dice[roll - 1], (int)(Math.random() * (230) + 120), (int)(Math.random() * (300) ) + 100, 30, 30, window);
    }
}