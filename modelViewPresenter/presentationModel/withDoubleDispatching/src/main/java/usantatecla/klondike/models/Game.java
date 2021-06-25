package usantatecla.klondike.models;

import java.util.*;

import usantatecla.klondike.types.Card;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.types.Suit;
import usantatecla.utils.ClosedInterval;

public class Game {

    public static final int NUMBER_OF_PILES = 7;
    private static ClosedInterval PILE_LIMITS = new ClosedInterval(0, Game.NUMBER_OF_PILES - 1);
    private Stock stock;
    private Waste waste;
    private Map<Suit, Foundation> foundations;
    private List<Pile> piles;

    public Game() {
        this.reset();
    }

    public void reset() {
        this.stock = new Stock();
        this.waste = new Waste();
        this.foundations = new HashMap<>();
        for (Suit suit : Suit.values()) {
            this.foundations.put(suit, new Foundation(suit));
        }
        this.piles = new ArrayList<>();
        for (int i = 0; i < Game.NUMBER_OF_PILES; i++) {
            this.piles.add(new Pile(i, this.stock));
        }
    }

    public boolean isComplete() {
        for (Suit suit : Suit.values()) {
            if (!this.foundations.get(suit).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public Error moveFromStockToWaste() {
        if (this.stock.empty()) {
            return Error.EMPTY_STOCK;
        }
        this.waste.push(this.stock.pop().flip());
        return Error.NULL;
    }

    public Error moveFromWasteToFoundation(Suit suit) {
        assert suit != null;

        if (this.waste.empty()) {
            return Error.EMPTY_WASTE;
        }
        Foundation foundation = this.foundations.get(suit);
        if (!foundation.fitsIn(this.waste.peek())) {
            return Error.NO_FIT_FOUNDATION;
        }
        foundation.push(this.waste.pop());
        return Error.NULL;
    }

    public Error moveFromWasteToStock() {
        if (!this.stock.empty()) {
            return Error.NO_EMPTY_STOCK;
        }
        if (this.waste.empty()) {
            return Error.EMPTY_WASTE;
        }
        while (!this.waste.empty()) {
            this.stock.push(this.stock.pop().flip());
        }
        return Error.NULL;
    }

    public Error moveFromWasteToPile(int index) {
        assert Game.PILE_LIMITS.isIncluded(index);

        if (this.waste.empty()) {
            return Error.EMPTY_WASTE;
        }
        Pile pile = this.piles.get(index);
        if (!pile.fitsIn(this.waste.peek())) {
            return Error.NO_FIT_PILE;
        }
        pile.push(Arrays.asList(this.waste.pop()));
        return Error.NULL;
    }

    public Error moveFromFoundationToPile(Suit suit, int index) {
        assert suit != null;
        assert Game.PILE_LIMITS.isIncluded(index);

        Foundation foundation = this.foundations.get(suit);
        if (foundation.empty()) {
            return Error.EMPTY_FOUNDATION;
        }
        Pile pile = this.piles.get(index);
        if (!pile.fitsIn(foundation.peek())) {
            return Error.NO_FIT_PILE;
        }
        pile.push(Arrays.asList(foundation.pop()));
        return Error.NULL;
    }

    public Error moveFromPileToFoundation(int index, Suit suit) {
        assert Game.PILE_LIMITS.isIncluded(index);
        assert suit != null;
        Pile pile = this.piles.get(index);
        if (pile.empty()) {
            return Error.EMPTY_PILE;
        }
        Foundation foundation = this.foundations.get(suit);
        Card card = pile.peek(1).get(0);
        if (!foundation.fitsIn(card)) {
            return Error.NO_FIT_FOUNDATION;
        }
        foundation.push(card);
        pile.pop(1);
        return Error.NULL;
    }

    public Error moveFromPileToPile(int originIndex, int targetIndex, int numberOfCards) {
        assert Game.PILE_LIMITS.isIncluded(originIndex);
        assert Game.PILE_LIMITS.isIncluded(targetIndex);
        assert (0 <= numberOfCards);
        if (originIndex == targetIndex) {
            return Error.SAME_PILE;
        }
        Pile originPile = this.piles.get(originIndex);
        Pile destinationPile = this.piles.get(targetIndex);
        if (originPile.areFaceUp(numberOfCards)) {
            return Error.NO_ENOUGH_CARDS_PILE;
        }
        List<Card> cards = originPile.peek(numberOfCards);
        if (!destinationPile.fitsIn(cards.get(cards.size() - 1))) {
            return Error.NO_FIT_PILE;
        }
        originPile.pop(numberOfCards);
        destinationPile.push(cards);
        return Error.NULL;
    }

    public Card peekStock() {
        if (this.stock.empty()) {
            return null;
        } 
        return this.stock.peek();
    }

    public Card peekWaste() {
        if (this.waste.empty()) {
            return null;
        } 
        return this.waste.peek();
    }

    public Card peekFoundation(Suit suit) {
        Foundation foundation = this.foundations.get(suit);
        if (foundation.empty()) {
            return null;
        } 
        return foundation.peek();
    }

    public Stack<Card> getPileCards(int index) {
        return this.piles.get(index).getCards();
    }

}
