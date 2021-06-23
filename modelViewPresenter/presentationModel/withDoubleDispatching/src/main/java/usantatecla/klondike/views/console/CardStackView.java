package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.models.Card;
import usantatecla.utils.IO;

public abstract class CardStackView {

    protected final Controller controller;

    private final String title;

    CardStackView(Controller controller, String title) {
        this.controller = controller;
        this.title = title;
    }

    protected void writeln(Card card) {
        IO.write(title);
        if (card == null)
            IO.writeln(Message.EMPTY);
        else
            new CardView(card).writeln();
    }

    public abstract void writeln();
}
