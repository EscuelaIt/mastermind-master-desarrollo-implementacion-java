package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.controllers.ResumeController;
import usantatecla.klondike.controllers.StartController;
import usantatecla.utils.YesNoDialog;
import usantatecla.klondike.views.View;
import usantatecla.klondike.views.console.menu.PlayMenu;

public class ConsoleView extends View {

    @Override
    public void interact(Controller controller) {
        if (controller instanceof StartController) {
            this.start((StartController) controller);
        } else {
            if (controller instanceof MoveController) {
                this.move((MoveController) controller);
            } else {
                this.resume((ResumeController) controller);
            }
        }
    }

    private void resume(ResumeController resumeController) {
        resumeController.resume(new YesNoDialog().read(Message.RESUME));

    }

    private void move(MoveController moveController) {
        new PlayMenu(moveController).execute();
        new GameView(moveController).writeln();
    }

    private void start(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
    }

}
