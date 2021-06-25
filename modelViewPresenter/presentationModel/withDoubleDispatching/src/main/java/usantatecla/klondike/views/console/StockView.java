package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.types.Card;
import usantatecla.klondike.views.console.types.Message;

public class StockView extends CardStackView {
    
    public StockView(Controller controller) {
        super(controller, Message.STOCK_TITLE.toString());
    }

    @Override
    public Card getPeek() {
        return this.controller.peekStock();
    }

}
