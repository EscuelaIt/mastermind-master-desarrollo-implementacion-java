package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;
import usantatecla.klondike.models.Suit;

public class MoveFromWasteToFoundationCommand extends Command {

    public MoveFromWasteToFoundationCommand(MoveController moveController) {
        super(CommandTitle.WASTE2FOUNDATION_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        return this.moveController.moveFromWasteToFoundation(suit);
    }
}
