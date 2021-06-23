package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.models.Suit;
import usantatecla.utils.IO;

public class SuitReader {

    public static Suit read() {
        char initial = IO.readChar(Message.READ_SUIT, Suit.initials());
        return Suit.find(initial);
    }
}
