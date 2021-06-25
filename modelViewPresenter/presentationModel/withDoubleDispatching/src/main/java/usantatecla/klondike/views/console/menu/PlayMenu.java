package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.utils.Menu;

public class PlayMenu extends Menu {

    public PlayMenu(MoveController moveController) {
        this.addCommand(new MoveFromStockToWasteCommand(moveController));
        this.addCommand(new MoveFromWasteToStockCommand(moveController));
        this.addCommand(new MoveFromWasteToFoundationCommand(moveController));
        this.addCommand(new MoveFromWasteToPileCommand(moveController));
        this.addCommand(new MoveFromFoundationToPileCommand(moveController));
        this.addCommand(new MoveFromPileToFoundationCommand(moveController));
        this.addCommand(new MoveFromPileToPileCommand(moveController));
    }

}
