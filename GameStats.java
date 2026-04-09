public class GameStats {
    private int totalGamesPlayed;
    private int wins;
    private int losses;

    public GameStats() {
        this.totalGamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public void recordWin() {
        wins++;
        totalGamesPlayed++;
    }

    public void recordLoss() {
        losses++;
        totalGamesPlayed++;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
}
public void printStats(){
    System.out.println("Wins: " + wins + " | Losses: " + losses + " | Total Games Played: " + totalGamesPlayed);
}
}
