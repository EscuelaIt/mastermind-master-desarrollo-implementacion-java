package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.views.console.types.Message;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(MoveController moveController) {
        super(Message.WASTE2STOCK_COMMAND.toString(), moveController);
    }

    @Override
    protected Error move() {
        return this.moveController.moveFromWasteToStock();
    }

}
