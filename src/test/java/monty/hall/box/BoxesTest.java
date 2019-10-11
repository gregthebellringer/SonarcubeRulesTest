package monty.hall.box;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxesTest {

    @Test
    public void shouldBeOneMoneyBox() {
        Boxes boxes = new Boxes();

        int amountOfMoneyBoxes = 0;
        for (int i = 0; i < Boxes.AMOUNT_OF_BOXES; i++) {
            if (boxes.getBoxesList().get(i).containsMoney()) {
                amountOfMoneyBoxes++;
            }
        }
        assertEquals(amountOfMoneyBoxes, 1);
    }

    @Test
    public void shouldBeTwoEmptyBoxes() {
        Boxes boxes = new Boxes();

        int amountOfEmptyBoxes = 0;
        for (int i = 0; i < Boxes.AMOUNT_OF_BOXES; i++) {
            if (boxes.getBoxesList().get(i).isEmpty()) {
                amountOfEmptyBoxes++;
            }
        }
        assertEquals(2, amountOfEmptyBoxes);
    }

    @Test
    public void shouldBeThreeEmptyBoxes() {
        Boxes boxes = new Boxes();
        boxes.addEmptyBoxes();

        int amountOfEmptyBoxes = 0;
        for (int i = 0; i < Boxes.AMOUNT_OF_BOXES; i++) {
            if (boxes.getBoxesList().get(i).isEmpty()) {
                amountOfEmptyBoxes++;
            }
        }
        assertEquals(Boxes.AMOUNT_OF_BOXES, amountOfEmptyBoxes);
    }
}