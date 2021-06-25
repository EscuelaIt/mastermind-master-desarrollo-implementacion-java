package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.klondike.views.console.types.PileDialog;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(MoveController moveController) {
        super(Message.WASTE2PILE_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        int pileIndex = new PileDialog().read(Message.DESTINATION.toString());
        return this.moveController.moveFromWasteToPile(pileIndex);
    }

}
