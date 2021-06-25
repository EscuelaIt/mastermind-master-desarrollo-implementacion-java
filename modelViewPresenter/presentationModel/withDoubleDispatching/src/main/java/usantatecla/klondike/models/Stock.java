package usantatecla.klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import usantatecla.klondike.types.Card;
import usantatecla.klondike.types.Number;
import usantatecla.klondike.types.Suit;

class Stock extends CardStack {

    Stock() {
        super();
        for (Suit suit : Suit.values()) {
            for (Number number : Number.values()) {
                this.cards.add(new Card(suit, number));
            }
        }
        Collections.shuffle(this.cards);
    }

    List<Card> pop(int amount) {
        assert 0 < amount && amount <= this.cards.size();

        List<Card> cards = new ArrayList<>(this.cards.subList(0, amount));
        this.cards.removeAll(cards);
        return cards;
    }

}
