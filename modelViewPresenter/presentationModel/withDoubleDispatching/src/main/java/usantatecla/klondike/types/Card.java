package usantatecla.klondike.types;

public class Card {
    
    private boolean facedUp;
    private Suit suit;
    private Number number;

    public Card(Suit suit, Number number) {
        assert suit != null;
        assert number != null;

        this.facedUp = false;
        this.suit = suit;
        this.number = number;
    }
    
    public boolean isFacedUp() {
        return facedUp;
    }

    public Card flip() {
        Card card = new Card(this.suit, this.number);
        if (!this.isFacedUp()){
            card.facedUp = true;
        } 
        return card;
    }

    public boolean isSuit(Suit suit) {
        return this.suit == suit;
    }
    
    public boolean sameColor(Card card) {
        return this.suit.getColor() == card.suit.getColor();
    }

    public boolean isNextTo(Card card) {
        return (this.getNumber().getValue() - 1) == card.getNumber().getValue();
    }

    public boolean isAs() {
        return this.number == Number.AS;
    }

    public boolean isKing(){
        return this.number == Number.KING;
    }

    public Number getNumber() {
        return this.number;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return "Card [facedUp=" + facedUp + ", number=" + number + ", suit=" + suit + "]";
    }

}
