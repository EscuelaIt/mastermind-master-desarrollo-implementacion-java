package usantatecla.klondike.controllers;

import usantatecla.klondike.models.Game;
import usantatecla.klondike.models.State;

public class ResumeController extends Controller {

    public ResumeController(Game game, State state) {
        super(game, state);
    }

    public void resume() {
        this.state.reset();
        this.game.reset();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor){
        controllerVisitor.visit(this);
    }
}
