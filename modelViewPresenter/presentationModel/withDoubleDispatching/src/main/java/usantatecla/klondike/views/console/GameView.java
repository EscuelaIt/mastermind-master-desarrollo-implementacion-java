package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.models.Game;
import usantatecla.klondike.models.Suit;
import usantatecla.utils.IO;

public class GameView {


    private final Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void writeln() {
        IO.writeln();
        IO.writeln(Message.GAME_TITLE);
        new StockView(this.controller).writeln();
        new WasteView(this.controller).writeln();
        IO.writeln(Message.FOUNDATIONS_TITLE);
        for (Suit suit : Suit.values()) {
            new FoundationView(this.controller, suit).writeln();
        }
        IO.writeln(Message.PILES_TITLE);
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            new PileView(this.controller, i).writeln();
        }
        IO.writeln(Message.GAME_END);
        IO.writeln();
    }
}
