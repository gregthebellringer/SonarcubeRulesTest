package monty.hall.statistics;

/**
 * The Statistics class is used to keeps track of games won or lost with a given strategy.
 *
 */

public class Statistics {

    private final PlayerStrategy playerStrategy;
    private Integer gamesWon = 0;
    private Integer gamesLost = 0;

    public Statistics(final PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }

    @Override
    public String toString() {
        return (String.format(("Strategy: '%s', Games Won: '%d', Total games: '%d', Win percentage: '%.2f'"),
                playerStrategy.toString(), gamesWon, gamesWon + gamesLost,
                (getWinPercentage()) * 100));
    }

    public Double getWinPercentage() {
        return (double) gamesWon / (gamesLost + gamesWon);
    }

    public void addGame(Boolean gameWon) {
        if (gameWon) {
            gamesWon++;
        } else {
            gamesLost++;
        }
    }
}
