package usantatecla.klondike.models;

public class Foundation extends CardStack {

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public boolean isComplete() {
        return this.cards.peek().isKing();
    }

    public boolean fitsIn(Card card) {
        assert card != null;

        return card.isSuit(this.suit) &&
                (card.isAs() || !this.empty() && card.isNextTo(this.peek()));
    }

    public Suit getSuit() {
        return this.suit;
    }
    
}
