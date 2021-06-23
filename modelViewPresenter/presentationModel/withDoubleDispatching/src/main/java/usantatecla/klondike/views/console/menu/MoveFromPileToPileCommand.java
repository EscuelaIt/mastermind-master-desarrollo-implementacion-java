package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;
import usantatecla.utils.ClosedInterval;
import usantatecla.utils.IO;

public class MoveFromPileToPileCommand extends Command {

    public MoveFromPileToPileCommand(MoveController moveController) {
        super(CommandTitle.PILE2PILE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        int originIndex = PileReader.readIndex(Message.ORIGIN);
        int destinationIndex = PileReader.readIndex(Message.DESTINATION);
        int numberOfCards = IO.readInt(Message.READ_NUMBER_OF_CARDS, new ClosedInterval(1, 13));
        return this.moveController.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }
}
