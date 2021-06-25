package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.types.Card;
import usantatecla.klondike.views.console.types.Message;

public class WasteView extends CardStackView {
    
    public WasteView(Controller controller) {
        super(controller, Message.WASTE_TITLE.toString());
    }

    @Override
    public Card getPeek() {
        return this.controller.peekWaste();
    }

}
