package monty.hall.box;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Boxes class represents the three boxes used in a single game on the Monty Hall game show.
 *
 */

public class Boxes {

    public static final int AMOUNT_OF_BOXES = 3;
    private List<Box> boxesList = new ArrayList<>(AMOUNT_OF_BOXES);

    public Boxes() {
        initializeBoxes();
    }

    private void initializeBoxes() {
        addEmptyBoxes();
        addMoneyBox(getRandomBoxIndex());
    }

    void addMoneyBox(final int index) {
        boxesList.get(index).setContent(Box.Content.MONEY);
    }

    void addEmptyBoxes() {
        for (int i = 0; i < AMOUNT_OF_BOXES; i++) {
            boxesList.add(i, new Box(Box.Content.EMPTY));
        }
    }

    public int getRandomBoxIndex() {
        Random random = new Random();
        return random.nextInt(AMOUNT_OF_BOXES);
    }

    public List<Box> getBoxesList() {
        return boxesList;
    }
}
