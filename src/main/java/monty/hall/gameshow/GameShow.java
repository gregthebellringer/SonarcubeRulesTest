package monty.hall.gameshow;

import monty.hall.box.Box;
import monty.hall.box.Boxes;

import java.util.Optional;

/**
 * The GameShow class represents the Monty Hall game show.
 *
 */

public class GameShow {

    Boxes boxes;
    Integer playerPickedBox;

    public void startNewGame() {
        boxes = new Boxes();
    }

    /**
     * The host opens a empty box which is not the player picked box.
     */
    public void hostOpensEmptyBox() {
        Optional<Box> emptyBox = boxes.getBoxesList().stream()
                .filter(box -> box.isEmpty() &&
                        !isPlayerPickedBox(box))
                .findFirst();

        emptyBox.ifPresent(Box::openBox);
    }

    /**
     * Checks if the strategy "stay with box" is a win.
     *
     * @return true if the player-picked box contains the money/is a win.
     */
    public boolean isStayStrategyWin() {
        return boxes.getBoxesList().get(playerPickedBox).containsMoney();
    }

    /**
     * Checks if the strategy "switch box" is a win.
     *
     * @return true if the remaining box (which the player gets if she/he switches) contains the money/is a win.
     */
    public boolean isSwitchStrategyWin() {
        Optional<Box> remainingBox = boxes.getBoxesList().stream()
                .filter(box -> !box.isOpen() &&
                        !isPlayerPickedBox(box))
                .findFirst();

        return remainingBox.map(Box::containsMoney).orElse(false);
    }

    private boolean isPlayerPickedBox(final Box box) {
        return box.equals(boxes.getBoxesList().get(playerPickedBox));
    }

    public void playerPicksBox() {
        playerPickedBox = boxes.getRandomBoxIndex();
    }
}
