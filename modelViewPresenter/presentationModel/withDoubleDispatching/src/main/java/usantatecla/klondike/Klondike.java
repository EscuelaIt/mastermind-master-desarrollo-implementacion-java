package usantatecla.klondike;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.controllers.Logic;
import usantatecla.klondike.views.View;

public class Klondike {

    private Logic logic;
    private View view;

    private Klondike() {
        this.logic = new Logic();
        this.view = new usantatecla.klondike.views.console.View();
    }

    public void play() {
        Controller controller;
        do {
            controller = this.logic.getController();
            this.view.interact(controller);
        } while (controller != null);
    }

    public static void main(String[] args) {
        new Klondike().play();
    }

}