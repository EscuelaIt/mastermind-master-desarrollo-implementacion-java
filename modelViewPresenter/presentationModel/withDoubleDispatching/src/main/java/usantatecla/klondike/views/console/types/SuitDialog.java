package usantatecla.klondike.views.console.types;

import usantatecla.klondike.types.Suit;
import usantatecla.utils.BoundedCharDialog;

public class SuitDialog {

    private static char[] initials = { 'H', 'D', 'c', 'p' };

    public Suit read() {
        char initial = new BoundedCharDialog(SuitDialog.initials).read(Message.READ_SUIT.toString());
        return this.find(initial);
    }


    public Suit find(char initial) {
        for (int i = 0; i < SuitDialog.initials.length; i++) {
            if (SuitDialog.initials[i]==initial) {
                return Suit.values()[i];
            }
        }
        assert false;
        return null;
    }

}
