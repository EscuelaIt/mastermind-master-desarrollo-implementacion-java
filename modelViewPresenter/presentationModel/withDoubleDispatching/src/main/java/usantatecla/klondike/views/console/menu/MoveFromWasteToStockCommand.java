package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;

public class MoveFromWasteToStockCommand extends Command {

    public MoveFromWasteToStockCommand(MoveController moveController) {
        super(CommandTitle.WASTE2STOCK_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        return this.moveController.moveFromWasteToStock();
    }
}
