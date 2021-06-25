package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.types.Suit;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.klondike.views.console.types.SuitDialog;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(MoveController moveController) {
        super(Message.WASTE2FOUNDATION_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = new SuitDialog().read();
        return this.moveController.moveFromWasteToFoundation(suit);
    }

}
