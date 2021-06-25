package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.types.Card;
import usantatecla.klondike.views.console.types.CardView;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.utils.Console;

import java.util.Stack;

public class PileView {

    private final Controller controller;
    private final int index;

    public PileView(Controller controller, int index) {
        this.controller = controller;
        this.index = index;
    }

    public void writeln() {
        Console.getInstance().write(Message.PILE_TITLE.toString(index + 1));
        final Stack<Card> cards = this.controller.getPileCards(index);
        if (cards.size() == 0){
            Console.getInstance().writeln(Message.EMPTY.toString());
        } else {
            boolean painted = false;
            for(int i=0; i<cards.size(); i++){
                if (cards.elementAt(i).isFacedUp()){
                    new CardView(cards.elementAt(i)).write();
                } else {
                    if (!painted){
                        new CardView(cards.elementAt(i)).write();
                        painted = true;
                    } else {
                        Console.getInstance().write(Message.CLOSE.toString());
                    }
                }
            }
            Console.getInstance().writeln();
        }
    }

}
