import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;
public class DiceGameViewer extends JFrame{
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;

    private DiceGame gameInfo;


    private Image xImage, oImage;
    public DiceGameViewer(DiceGame gameInfo){
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
        this.gameInfo = gameInfo;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }


    public Image getXImage() {
        return xImage;
    }

    public Image getOImage() {
        return oImage;
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 500);
        g.setColor(Color.black);
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
            paintTable(g);
        }
        if(gameInfo.getGameState() == 4){
            paintTable(g);
            paintDice(g);
        }
    }

    public void paintState0(Graphics g){
        g.setFont(new Font("Serif", Font.PLAIN, 10));
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

    public void paintState1(Graphics g){
        paintState0(g);
        g.drawString("Player one, please enter your name, and then your knockout", 100, 400);
        g.drawString("number. It must be between 6 and 8, inclusive.", 100, 420);
    }

    public void paintState2(Graphics g){
        paintState0(g);
        g.drawString("Player two, please enter your name, and then your knockout", 100, 400);
        g.drawString("number. It must be between 6 and 8, inclusive.", 100, 420);
    }
    public void paintTable(Graphics g){
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
        paintIndicator(g);
    }

    public void paintIndicator(Graphics g){
        g.setColor(Color.orange);
        int[] yPoints = {350, 330, 350};
        int[] xPoints = new int[3];
        if(gameInfo.getPlayerTurn() == 1){
            xPoints[0] = 40;
            xPoints[1] = 60;
            xPoints[2] = 80;
        }
        if(gameInfo.getPlayerTurn() == 2){
            xPoints[0] = 500-40;
            xPoints[1] = 500-60;
            xPoints[2] = 500-80;
        }
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public void paintDice(Graphics g){
        gameInfo.getD1().draw(g);
        gameInfo.getD2().draw(g);
    }



}
