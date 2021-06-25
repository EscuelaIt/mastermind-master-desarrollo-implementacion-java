package usantatecla.klondike.views.console.types;

import java.util.HashMap;
import java.util.Map;

import usantatecla.klondike.types.Card;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.types.Suit;

public enum Message {

    GAME_TITLE("------------------- KLONDIKE ---------------------"),
    GAME_END("--------------------------------------------------"), 
    STOCK_TITLE("STOCK: "), 
    WASTE_TITLE("WASTE: "),
    FOUNDATIONS_TITLE("FOUNDATIONS: "), 
    PILES_TITLE("PILES:"), 
    PILE_TAG("#number"), 
    PILE_TITLE("\t" + PILE_TAG + ":"),
    FOUNDATION_TAG("#foundation"), 
    FOUNDATION_TITLE("\t" + FOUNDATION_TAG + ": "),

    STOCK2WASTE_COMMAND("Move from stock to waste"), 
    WASTE2STOCK_COMMAND("Move from waste to stock"),
    WASTE2FOUNDATION_COMMAND("Move from waste to foundation"), 
    WASTE2PILE_COMMAND("Move from waste to pile"),
    FOUNDATION2PILE_COMMAND("Move from foundation to pile"), 
    PILE2FOUNDATION_COMMAND("Move from pile to foundation"),
    PILE2PILE_COMMAND("Move from pile to pile"), 
    INVALID_MOVE("Invalid move!!! "),

    EMPTY("-"), 
    FACE_DOWN("[X, X]"), 
    NUMBER_TAG("#number"), 
    SUIT_TAG("#suit"), 
    OPEN("["), 
    CLOSE("]"),
    CARD_FORMAT("" + OPEN + NUMBER_TAG + ", " + SUIT_TAG + CLOSE),

    TITLE_TAG("#title"), 
    READ_PILE("Choose the " + TITLE_TAG + " pile number(1-7): "), 
    DESTINATION("destination"),
    ORIGIN("origin"),

    READ_NUMBER_OF_CARDS("How many cards do you want to move?: "), 
    READ_SUIT("Choose a suit: "),

    RESUME("Do you want to resume?");

    public static String[] NUMBER_INITIALS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    public static String[] SUIT_INITIALS = { "H", "D", "c", "p" };

    private String message;

    private Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public String toString(String message) {
        assert this == Message.READ_PILE;

        return this.message.replace(Message.TITLE_TAG.toString(), message);
    }

    public String toString(Suit suit) {
        assert this == Message.FOUNDATION_TITLE;

        return this.message.replace(Message.FOUNDATION_TAG.message, suit.toString().toLowerCase());
    }

    public String toString(Card card) {
        assert this == Message.CARD_FORMAT;

        return this.message
                .replace(Message.NUMBER_TAG.toString(), NUMBER_INITIALS[card.getNumber().ordinal()])
                .replace(Message.SUIT_TAG.toString(), SUIT_INITIALS[card.getSuit().ordinal()]);
    }

    private static Map<Error, String> errors;
  static {
    Message.errors = new HashMap<>();
    Message.errors.put(Error.EMPTY_STOCK, "No cards in stock to move.");
    Message.errors.put(Error.EMPTY_WASTE, "No cards in waste to move.");
    Message.errors.put(Error.EMPTY_FOUNDATION, "No cards in foundation to move.");
    Message.errors.put(Error.EMPTY_PILE, "No cards in pile to move.");
    Message.errors.put(Error.NO_EMPTY_STOCK, "Stock is not empty.");
    Message.errors.put(Error.NO_FIT_FOUNDATION, "Foundations should be built up by suit from Ace to King.");
    Message.errors.put(Error.NO_FIT_PILE, "Piles should be built down by alternate colors.");
    Message.errors.put(Error.SAME_PILE, "Same origin and destination pile index.");
    Message.errors.put(Error.NO_ENOUGH_CARDS_PILE, "There is no enough cards in the pile to move.");
  }

    public String toString(Error error) {
        assert this == Message.INVALID_MOVE;

        return this.message + Message.errors.get(error);
    }

    public String toString(int value) {
        assert this == Message.PILE_TITLE;

        return this.message.replace(Message.NUMBER_TAG.toString(), "" + value);
    }

}
