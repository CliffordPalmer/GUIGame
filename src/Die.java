import javax.swing.*;
import java.awt.*;
public class Die
{
    /** Instance Variables **/

    private int numSides;

    private Image[] dice;
    /** Constructors **/

    public Die(int numSides) {
        // TODO: Complete this constructor
        // NOTE: if the user enters an int less than 2
        // set numSides to 6.
        if (numSides < 2){
            this.numSides = 6;
        }
        else{
            this.numSides = numSides;
        }
        dice = new Image[6];
        dice[0] = new ImageIcon("Resources/dice-six-faces-one.png").getImage();
        dice[1] = new ImageIcon("Resources/dice-six-faces-two.png").getImage();
        dice[2] = new ImageIcon("Resources/dice-six-faces-three.png").getImage();
        dice[3] = new ImageIcon("Resources/dice-six-faces-four.png").getImage();
        dice[4] = new ImageIcon("Resources/dice-six-faces-five.png").getImage();
        dice[5] = new ImageIcon("Resources/dice-six-faces-six.png").getImage();
    }

    public Die() {
        numSides = 6;
    }

    /** Methods **/

    /**
     * Returns the number of sides on the Die.
     */
    public int getSides() {
        return numSides;
    }

    /**
     * Returns a random int between 1 and
     * the number of sides on the Die
     */
    public int roll(int rollNum) {
        // TODO: complete roll()
        int sum = 0;
        for (int i = 0; i < rollNum; i++){
            sum += (int)(Math.random() * (numSides) + 1);
        }
        return sum;
    }

    /**
     * Rolls the dice the numRolls times
     * and returns the max value of the rolls
     */
    public int getMaxRoll(int numRolls) {
        // TODO: complete getMaxRoll()
        int highest = 0;
        for(int i = 0; i < numRolls; i++){
            int roll = roll(1);
            if(roll > highest){
                highest = roll;
            }
        }
        return highest;
    }

    /**
     * Returns a String in the following form:
     * "This is a n-sided die."
     */

    public void drawDie(Graphics g){

    }
    public String toString() {
        // TODO: complete toString()
        return "You are using a " + numSides + "-sided die.";
    }


}