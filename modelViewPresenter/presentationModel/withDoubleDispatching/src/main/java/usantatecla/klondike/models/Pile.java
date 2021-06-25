package usantatecla.klondike.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import usantatecla.klondike.types.Card;

class Pile extends CardStack {

    Pile(int position, Stock stock) {
        super();
        this.cards.addAll(stock.pop(position + 1));
        this.flipPeek();
    }
    
    private void flipPeek() {
        this.cards.push(this.cards.pop().flip());
    }

    boolean fitsIn(Card card) {
        assert card != null;

        return (this.cards.empty() && card.isKing()) ||
                (!this.cards.empty() && this.cards.peek().isNextTo(card) 
                && this.cards.peek().sameColor(card));
    }

    boolean areFaceUp(int numberOfCards) {
        for (Card card : this.peek(numberOfCards)) {
            if (!card.isFacedUp()){
                return false;
            }
        }
        return true;
    }

    List<Card> peek(int numberOfCards) {
        return new ArrayList<>(this.cards.subList(this.cards.size() - numberOfCards, this.cards.size()));
    }

    void pop(int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            this.cards.pop();
        }
        if (!this.cards.empty() && !this.cards.peek().isFacedUp()) {
            this.flipPeek();
        }
    }

    void push(List<Card> cards) {
        assert cards != null;

        this.cards.addAll(cards);
    }

    Stack<Card> getCards() {
        return this.cards;
    }

}
