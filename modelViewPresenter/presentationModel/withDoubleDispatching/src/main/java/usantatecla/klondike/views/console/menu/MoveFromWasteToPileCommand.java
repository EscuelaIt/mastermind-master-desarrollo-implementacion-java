package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;

public class MoveFromWasteToPileCommand extends Command {

    public MoveFromWasteToPileCommand(MoveController moveController) {
        super(CommandTitle.WASTE2PILE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        int pileIndex = PileReader.readIndex(Message.DESTINATION);
        return this.moveController.moveFromWasteToPile(pileIndex);
    }
}
