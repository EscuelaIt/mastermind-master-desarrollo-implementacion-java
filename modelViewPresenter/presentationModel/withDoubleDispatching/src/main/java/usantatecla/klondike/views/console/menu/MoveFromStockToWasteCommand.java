package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.views.console.types.Message;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(MoveController moveController) {
        super(Message.STOCK2WASTE_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        return this.moveController.moveFromStockToWaste();
    }

}
