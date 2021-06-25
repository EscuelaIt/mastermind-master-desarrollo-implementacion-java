package usantatecla.klondike.types;

public enum Error {

    EMPTY_STOCK,
    EMPTY_WASTE,
    EMPTY_FOUNDATION,
    EMPTY_PILE,
    NO_EMPTY_STOCK,
    NO_FIT_FOUNDATION,
    NO_FIT_PILE,
    SAME_PILE,
    NO_ENOUGH_CARDS_PILE,
    NULL;

    public boolean isNull(){
        return this == Error.NULL;
    }

}
