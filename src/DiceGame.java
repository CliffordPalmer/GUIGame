import java.util.Scanner;
public class DiceGame {
    private DiceGameViewer window;

    private Die d1, d2;

    private int p1Sum;
    private int p2Sum;

    private Player p1, p2;
    private String winner;

    public DiceGame(){
        window = new DiceGameViewer(this);
        d1 = new Die(6);
        d2 = new Die(6);
    }

    public void run() {
        System.out.println("Welcome to Knockout! This is a fast dice game that can be played with two people. At the beginning of the game, each user is prompted for their name and a knockout number. When entering this information, please type your name, hit the return key, type your knockout number, and then hit the return key again. Once both players have provided their name and knockout number, the game begins! Each turn, each player takes turns rolling their die twice. If the sum of their two rolls add up to their knockout number, they are knocked out! This adds a game to their opponents win count, before the users are asked if they would like to play another round. Once the users have decided to end the game, the console will print out the winner and their win count!");
        boolean contn = true;
        // create a scanner to read user input
        Scanner input = new Scanner(System.in);

        // notify the user of their choice
        System.out.println(d1.toString() + "\n");

        // take user input to set the name of each player, and their knockout number
        System.out.println("Player one, please enter your name, and then your knockout number. Your knockout number must be between " + d1.getSides() + " and " + (d1.getSides() + 2) + ", inclusive:");
        p1 = new Player(input.nextLine(), input.nextInt());
        input.nextLine();
        System.out.println("Thank you! Player two, please enter your name and then your knockout number. It must follow the same criteria as " + p1.getName() + "'s knockout number:");
        p2 = new Player(input.nextLine(), input.nextInt());
        input.nextLine();


        do {
            do {
                do {
                    System.out.println(p1.getName() + ", would you like to roll?(y/n)");
                } while (!(input.nextLine().equals("y")));
                p1Sum = d1.roll(2);
                System.out.println(p1.getName() + " rolled " + p1Sum + "!");
                if (p1Sum == p1.getNum()) {
                    System.out.println("Oops! Player one is knocked out!");
                    p2.addWin();
                    break;
                }
                do {
                    System.out.println(p2.getName() + ", would you like to roll?(y/n)");
                } while (!(input.nextLine().equals("y")));
                p2Sum = d2.roll(2);
                System.out.println(p2.getName() + " rolled " + p2Sum + " !");
                if (p2Sum == p2.getNum()) {
                    System.out.println("Oops! Player two is knocked out!");
                    p1.addWin();
                    break;
                }
            } while (true);
            System.out.println("Would you like to play another round?(y/n)");
            if (!(input.nextLine().equals("y"))) {
                break;
            } else {
                System.out.println("Awesome!");
            }
        } while (contn = true);
        if (p1.getWins() > p2.getWins()) {
            System.out.println(p1.getName() + " wins, with " + p1.getWins() + " total rounds won!");
        } else if (p2.getWins() > p1.getWins()) {
            System.out.println(p2.getName() + " wins, with " + p2.getWins() + " total rounds won!");
        } else {
            System.out.println("This game ended in a draw. Each player had " + p1.getWins() + " total wins!");
        }
    }

    public static void main(String[] args) {
        DiceGame g1 = new DiceGame();
        g1.run();
    }
}