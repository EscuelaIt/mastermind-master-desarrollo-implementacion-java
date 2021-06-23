package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;
import usantatecla.klondike.models.Suit;

public class MoveFromFoundationToPileCommand extends Command {

    public MoveFromFoundationToPileCommand(MoveController moveController) {
        super(CommandTitle.FOUNDATION2PILE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        Suit suit = SuitReader.read();
        int pileIndex = PileReader.readIndex(Message.DESTINATION);
        return this.moveController.moveFromFoundationToPile(suit, pileIndex);
    }
}
