package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.types.Suit;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.klondike.views.console.types.PileDialog;
import usantatecla.klondike.views.console.types.SuitDialog;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(MoveController moveController) {
        super(Message.FOUNDATION2PILE_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = new SuitDialog().read();
        int pileIndex = new PileDialog().read(Message.DESTINATION.toString());
        return this.moveController.moveFromFoundationToPile(suit, pileIndex);
    }

}
