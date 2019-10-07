package monty.hall.simulation;

import monty.hall.gameshow.GameShow;
import monty.hall.statistics.PlayerStrategy;
import monty.hall.statistics.Statistics;

/**
 * Simulates the Monty Hall problem by using the GameShow class and
 * prints the statistics from the simulation by using the Statistics class.
 *
 */

public class Simulation {

    private GameShow gameShow = new GameShow();

    /**
     * Runs multiple iterations of the game.
     * When simulation is done, prints the statistics of the different strategies from the simulations.
     *
     * @param amountOfGames that will be simulated.
     */
    public void runSimulations(final Integer amountOfGames) {
        Statistics stayStatistics = new Statistics(PlayerStrategy.STAY);
        Statistics switchStatistics = new Statistics(PlayerStrategy.SWITCH);

        for (int i = 0; i < amountOfGames; i++) {
            simulateOneGame(stayStatistics, switchStatistics);
        }

        System.out.println(stayStatistics.toString());
        System.out.println(switchStatistics.toString());
    }

    /**
     * Runs one iteration of the game on the game show.
     * 1) Player picks a box.
     * 2) The host opens one empty box (which isn't the player-picked box).
     * 3) We check if "stay with box" or "switch box" won this game.
     * 4) Add the result to the statistics class.
     *
     * @param stayStatistics   Statistics object for PlayerStrategy.STAY.
     * @param switchStatistics Statistics object for PlayerStrategy.SWITCH.
     */
    private void simulateOneGame(final Statistics stayStatistics, final Statistics switchStatistics) {
        gameShow.startNewGame();
        gameShow.playerPicksBox();
        gameShow.hostOpensEmptyBox();

        final Boolean isStayWin = gameShow.isStayStrategyWin();
        final Boolean isSwitchWin = gameShow.isSwitchStrategyWin();

        stayStatistics.addGame(isStayWin);
        switchStatistics.addGame(isSwitchWin);
    }
}
