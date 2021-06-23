package usantatecla.klondike.controllers;

import usantatecla.klondike.models.Game;
import usantatecla.klondike.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    public void start() {
        this.state.next();
    }
}
