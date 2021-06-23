package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;
import usantatecla.klondike.models.Suit;

public class MoveFromPileToFoundationCommand extends Command {

    public MoveFromPileToFoundationCommand(MoveController moveController) {
        super(CommandTitle.PILE2FOUNDATION_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        int pileIndex = PileReader.readIndex(Message.ORIGIN);
        Suit suit = SuitReader.read();
        return this.moveController.moveFromPileToFoundation(pileIndex, suit);
    }
}
