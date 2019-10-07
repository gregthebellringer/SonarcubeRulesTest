package monty.hall.gameshow;


import monty.hall.box.Box;
import monty.hall.box.Box;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameShowTest {

    @Test
    public void hostOpensOneEmptyBox() {
        GameShow gameShow = new GameShow();
        gameShow.startNewGame();
        gameShow.playerPicksBox();
        gameShow.hostOpensEmptyBox();

        Object[] emptyAndOpenBox = gameShow.boxes.getBoxesList().stream()
                .filter(box -> box.isOpen() && box.isEmpty())
                .toArray();

        Boolean onlyOneEmptyAndOpenBox = emptyAndOpenBox.length == 1;
        assertTrue(onlyOneEmptyAndOpenBox);
    }

    @Test
    public void playerPickedOneBox() {
        GameShow gameShow = new GameShow();
        gameShow.startNewGame();
        gameShow.playerPicksBox();

        Boolean playerPickedABox = 0 <= gameShow.playerPickedBox
                && gameShow.playerPickedBox < gameShow.boxes.AMOUNT_OF_BOXES;
        assertTrue(playerPickedABox);
    }

    @Test
    public void stayIsWinFalse() {
        GameShow gameShow = new GameShow();
        gameShow.startNewGame();
        gameShow.boxes.getBoxesList().get(0).setContent(Box.Content.MONEY);
        gameShow.boxes.getBoxesList().get(1).setContent(Box.Content.EMPTY);
        gameShow.boxes.getBoxesList().get(2).setContent(Box.Content.EMPTY);
        gameShow.playerPickedBox = 1;
        gameShow.boxes.getBoxesList().get(2).openBox();
        Boolean isStayStrategyWin = gameShow.isStayStrategyWin();
        assertFalse(isStayStrategyWin);
    }

    @Test
    public void stayIsWinTrue() {
        GameShow gameShow = new GameShow();
        gameShow.startNewGame();
        gameShow.boxes.getBoxesList().get(0).setContent(Box.Content.MONEY);
        gameShow.boxes.getBoxesList().get(1).setContent(Box.Content.EMPTY);
        gameShow.boxes.getBoxesList().get(2).setContent(Box.Content.EMPTY);
        gameShow.playerPickedBox = 0;
        gameShow.boxes.getBoxesList().get(2).openBox();
        Boolean isStayStrategyWin = gameShow.isStayStrategyWin();
        assertTrue(isStayStrategyWin);
    }

    @Test
    public void switchIsWinFalse() {
        GameShow gameShow = new GameShow();
        gameShow.startNewGame();
        gameShow.boxes.getBoxesList().get(0).setContent(Box.Content.EMPTY);
        gameShow.boxes.getBoxesList().get(1).setContent(Box.Content.MONEY);
        gameShow.boxes.getBoxesList().get(2).setContent(Box.Content.EMPTY);
        gameShow.playerPickedBox = 1;
        gameShow.boxes.getBoxesList().get(2).openBox();
        Boolean isSwitchStrategyWin = gameShow.isSwitchStrategyWin();
        assertFalse(isSwitchStrategyWin);
    }

    @Test
    public void switchIsWinTrue() {
        GameShow gameShow = new GameShow();
        gameShow.startNewGame();
        gameShow.boxes.getBoxesList().get(0).setContent(Box.Content.MONEY);
        gameShow.boxes.getBoxesList().get(1).setContent(Box.Content.EMPTY);
        gameShow.boxes.getBoxesList().get(2).setContent(Box.Content.EMPTY);
        gameShow.playerPickedBox = 1;
        gameShow.boxes.getBoxesList().get(2).openBox();
        Boolean isSwitchStrategyWin = gameShow.isSwitchStrategyWin();
        assertTrue(isSwitchStrategyWin);
    }


}