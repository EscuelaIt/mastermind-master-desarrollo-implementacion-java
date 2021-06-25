package usantatecla.klondike.controllers;

import usantatecla.klondike.models.Game;
import usantatecla.klondike.models.State;
import usantatecla.klondike.types.Card;
import usantatecla.klondike.types.Suit;

import java.util.Stack;

public abstract class Controller {

    protected Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public Card peekStock() {
        return this.game.peekStock();
    }

    public Card peekWaste() {
        return this.game.peekWaste();
    }

    public Card peekFoundation(Suit suit) {
        return this.game.peekFoundation(suit);
    }


    public Stack<Card> getPileCards(int index) {
        return this.game.getPileCards(index);
    }

    public abstract void accept(ControllerVisitor controllerVisitor);

}
