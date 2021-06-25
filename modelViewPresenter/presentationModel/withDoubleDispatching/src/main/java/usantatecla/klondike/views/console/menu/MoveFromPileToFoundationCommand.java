package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.types.Suit;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.klondike.views.console.types.PileDialog;
import usantatecla.klondike.views.console.types.SuitDialog;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(MoveController moveController) {
        super(Message.PILE2FOUNDATION_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        int pileIndex = new PileDialog().read(Message.ORIGIN.toString());
        Suit suit = new SuitDialog().read();
        return this.moveController.moveFromPileToFoundation(pileIndex, suit);
    }

}
