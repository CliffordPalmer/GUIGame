public class Player {

    // Instance Variables
    private String playerName;
    private int knockoutNum;
    private int wins;

    // Constructor
    public Player(String playerName, int knockoutNum){
        this.playerName = playerName;
        this.knockoutNum = knockoutNum;
        wins = 0;
    }

    public String getName(){
        return playerName;
    }

    public int getNum(){
        return knockoutNum;
    }

    public int getWins(){
        return wins;
    }

    public void addWin(){
        wins += 1;
    }
}