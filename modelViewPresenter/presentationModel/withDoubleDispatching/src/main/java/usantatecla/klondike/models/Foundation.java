package usantatecla.klondike.models;

import usantatecla.klondike.types.Card;
import usantatecla.klondike.types.Suit;

class Foundation extends CardStack {

    private Suit suit;
        
    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public boolean isComplete() {
        return !this.cards.empty() && this.cards.peek().isKing();
    }

    public boolean fitsIn(Card card) {
        assert card != null;

        return card.isSuit(this.suit) &&
                (this.empty() && card.isAs() 
                || !this.empty() && card.isNextTo(this.peek()));
    }

    public Suit getSuit() {
        return this.suit;
    }
    
}
