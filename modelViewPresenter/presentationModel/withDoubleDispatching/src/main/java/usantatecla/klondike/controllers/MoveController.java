package usantatecla.klondike.controllers;

import usantatecla.klondike.models.Game;
import usantatecla.klondike.models.State;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.types.Number;
import usantatecla.klondike.types.Suit;

public class MoveController extends Controller {

    public MoveController(Game game, State state) {
        super(game, state);
    }

    public int getMaxPileLength() {
        return Game.NUMBER_OF_PILES + Number.values().length - 1;
    }

    public Error moveFromFoundationToPile(Suit suit, int pileIndex) {
        return this.game.moveFromFoundationToPile(suit, pileIndex);
    }

    public Error moveFromPileToFoundation(int pileIndex, Suit suit) {
        Error error = this.game.moveFromPileToFoundation(pileIndex, suit);
        if (error == null && this.game.isComplete()) {
            this.state.next();
        }
        return error;
    }

    public Error moveFromPileToPile(int originIndex, int destinationIndex, int numberOfCards) {
        return this.game.moveFromPileToPile(originIndex, destinationIndex, numberOfCards);
    }

    public Error moveFromStockToWaste() {
        return this.game.moveFromStockToWaste();
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        Error error = this.game.moveFromWasteToFoundation(suit);
        if (error == null && this.game.isComplete()) {
            this.state.next();
        }
        return error;
    }

    public Error moveFromWasteToPile(int pileIndex) {
        return this.game.moveFromWasteToPile(pileIndex);
    }

    public Error moveFromWasteToStock() {
        return this.game.moveFromWasteToStock();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
