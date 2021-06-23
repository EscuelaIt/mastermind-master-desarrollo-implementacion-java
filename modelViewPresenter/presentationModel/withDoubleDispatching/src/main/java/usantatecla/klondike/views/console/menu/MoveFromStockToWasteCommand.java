package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.models.Error;

public class MoveFromStockToWasteCommand extends Command {

    public MoveFromStockToWasteCommand(MoveController moveController) {
        super(CommandTitle.STOCK2WASTE_COMMAND.getTitle(), moveController);
    }

    @Override
    protected Error move() {
        return this.moveController.moveFromStockToWaste();
    }
}
