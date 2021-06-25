package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.models.Game;
import usantatecla.klondike.types.Suit;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.utils.Console;

public class GameView {

    private final Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void writeln() {
        Console.getInstance().writeln();
        Console.getInstance().writeln(Message.GAME_TITLE.toString());
        new StockView(this.controller).writeln();
        new WasteView(this.controller).writeln();
        Console.getInstance().writeln(Message.FOUNDATIONS_TITLE.toString());
        for (Suit suit : Suit.values()) {
            new FoundationView(this.controller, suit).writeln();
        }
        Console.getInstance().writeln(Message.PILES_TITLE.toString());
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            new PileView(this.controller, i).writeln();
        }
        Console.getInstance().writeln(Message.GAME_END.toString());
    }

}
