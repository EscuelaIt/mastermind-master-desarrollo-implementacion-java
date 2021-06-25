package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.klondike.views.console.types.PileDialog;
import usantatecla.utils.BoundedIntDialog;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(MoveController moveController) {
        super(Message.PILE2PILE_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        int originIndex = new PileDialog().read(Message.ORIGIN.toString());
        int destinationIndex = new PileDialog().read(Message.DESTINATION.toString());
        int maxPileLength = this.moveController.getMaxPileLength();
        int numberOfCards = new BoundedIntDialog(1, maxPileLength).read(Message.READ_NUMBER_OF_CARDS.toString());
        return this.moveController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

}
