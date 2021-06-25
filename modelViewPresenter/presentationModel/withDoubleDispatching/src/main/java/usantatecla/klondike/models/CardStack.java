package usantatecla.klondike.models;

import java.util.Stack;

import usantatecla.klondike.types.Card;

abstract class CardStack {

  protected Stack<Card> cards;

  protected CardStack() {
        this.cards = new Stack<>();
    }

  public boolean empty() {
    return this.cards.empty();
  }

  public Card peek() {
    assert !this.cards.empty();

    return this.cards.peek();
  }

  public Card pop() {
    assert !this.cards.empty();

    return this.cards.pop();
  }

  public void push(Card card) {
    this.cards.push(card);
  }

}
