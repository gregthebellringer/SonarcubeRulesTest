package monty.hall.box;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void isEmpty() {
        Box emptyBox = new Box(Box.Content.EMPTY);
        assertTrue(emptyBox.isEmpty());
    }

    @Test
    public void containsMoney() {
        Box boxContainingMoney = new Box(Box.Content.MONEY);
        assertTrue(boxContainingMoney.containsMoney());
    }

    @Test
    public void openBox() {
        Box emptyBox = new Box(Box.Content.EMPTY);
        emptyBox.openBox();
        assertTrue(emptyBox.isOpen());
    }

    @Test
    public void setContent() {
        Box box = new Box(Box.Content.EMPTY);
        assertTrue(box.isEmpty());
        box.setContent(Box.Content.MONEY);
        assertTrue(box.containsMoney());
    }
}