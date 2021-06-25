package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.types.Card;
import usantatecla.klondike.types.Suit;
import usantatecla.klondike.views.console.types.Message;

public class FoundationView extends CardStackView {
    
    private final Suit suit;

    public FoundationView(Controller controller, Suit suit) {
        super(controller, Message.FOUNDATION_TITLE.toString(suit));
        this.suit = suit;
    }

    @Override
    public Card getPeek() {
        return this.controller.peekFoundation(suit);
    }

}
