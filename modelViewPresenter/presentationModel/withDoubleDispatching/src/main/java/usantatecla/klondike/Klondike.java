package usantatecla.klondike;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.controllers.Logic;
import usantatecla.klondike.views.View;
import usantatecla.klondike.views.console.ConsoleView;

public class Klondike {

    private Logic logic;
    private View view;

    private Klondike() {
        this.logic = new Logic();
        this.view = new ConsoleView();
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

    public void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            this.view.interact(controller);
        } while (controller != null);
    }
}