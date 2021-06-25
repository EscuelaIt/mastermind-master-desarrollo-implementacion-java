package usantatecla.klondike.types;

public enum Suit {

    HEARTS(Color.RED),
    DIAMONDS(Color.RED),
    CLOVERS(Color.BLACK),
    PIKES(Color.BLACK);

    private final Color color;

    Suit(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

}
