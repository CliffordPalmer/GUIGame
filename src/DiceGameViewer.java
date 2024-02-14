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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();
        this.gameInfo = gameInfo;
    }


    public Image getXImage() {
        return xImage;
    }

    public Image getOImage() {
        return oImage;
    }

    public void paint(Graphics g) {
        paintTable(g);
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
        g.setColor(Color.orange);
        int[] xPoints = {40, 60, 80};
        int[] yPoints = {350, 330, 350};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public void paintIndicator(Graphics g){
        g.setColor(Color.orange);
        int[] yPoints = {350, 330, 350};

        int[] xPoints = {40, 60, 80};

        g.fillPolygon(xPoints, yPoints, 3);
    }



}
