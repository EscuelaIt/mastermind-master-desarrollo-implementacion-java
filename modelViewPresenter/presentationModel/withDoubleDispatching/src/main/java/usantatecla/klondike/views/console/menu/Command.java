package usantatecla.klondike.views.console.menu;

import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.types.Error;
import usantatecla.klondike.views.console.types.Message;
import usantatecla.utils.Console;

public abstract class Command extends usantatecla.utils.Command {

    protected MoveController moveController;

    protected Command(String title, MoveController moveController) {
        super(title);
        this.moveController = moveController;
    }

    @Override
    protected void execute() {
        Error error = this.move();
        if (!error.isNull()) {
            Console.getInstance().writeln(Message.INVALID_MOVE.toString(error));
        }
    }

    protected abstract Error move();

}
