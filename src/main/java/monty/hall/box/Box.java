package monty.hall.box;

/**
 * Box class represents a single box in the Monty Hall Game Show.
 *
 */

public class Box {

    private Content content;
    private Boolean isOpen = false;

    public Box(Content content) {
        this.content = content;
    }

    public Boolean isOpen() {
        return isOpen;
    }

    public boolean isEmpty() {
        return this.content == Content.EMPTY;
    }

    public boolean containsMoney() {
        return this.content == Box.Content.MONEY;
    }

    public void openBox() {
        isOpen = true;
    }

    public void setContent(final Content content) {
        this.content = content;
    }

    public enum Content {
        MONEY,
        EMPTY
    }
}