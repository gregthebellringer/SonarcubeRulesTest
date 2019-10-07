package monty.hall.statistics;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticsTest {

    @Test
    public void getWinPercentage075() {
        Statistics stats = new Statistics(PlayerStrategy.STAY);
        stats.addGame(true);
        stats.addGame(true);
        stats.addGame(true);
        assertEquals(stats.getWinPercentage(), 1.0, 0.1);
        stats.addGame(false);
        assertEquals(stats.getWinPercentage(), 0.75, 0.1);
    }

    @Test
    public void getWinPercentage025() {
        Statistics stats = new Statistics(PlayerStrategy.SWITCH);
        stats.addGame(false);
        stats.addGame(false);
        stats.addGame(false);
        assertEquals(stats.getWinPercentage(), 0.0, 0.1);
        stats.addGame(true);
        assertEquals(stats.getWinPercentage(), 0.25, 0.1);
    }
}