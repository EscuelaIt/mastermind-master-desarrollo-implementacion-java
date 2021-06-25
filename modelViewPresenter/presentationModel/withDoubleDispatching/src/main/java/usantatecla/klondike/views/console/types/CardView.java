package usantatecla.klondike.views.console.types;

import usantatecla.klondike.types.Card;
import usantatecla.utils.Console;

public class CardView {

    private final Card card;

    public CardView(Card card) {
        this.card = card;
    }

    public void write() {
        String message = Message.EMPTY.toString();
        if (this.card != null){
            message = Message.FACE_DOWN.toString();
            if (this.card.isFacedUp()){
                message = Message.CARD_FORMAT.toString(this.card);
            }
        }
        Console.getInstance().write(message);
    }

    public void writeln() {
        this.write();
        Console.getInstance().writeln();
    }

}
