package usantatecla.klondike.views.console;

import usantatecla.klondike.controllers.Controller;
import usantatecla.klondike.controllers.ControllerVisitor;
import usantatecla.klondike.controllers.MoveController;
import usantatecla.klondike.controllers.ResumeController;
import usantatecla.klondike.controllers.StartController;
import usantatecla.utils.YesNoDialog;
import usantatecla.klondike.views.console.menu.PlayMenu;
import usantatecla.klondike.views.console.types.Message;

public class View extends usantatecla.klondike.views.View implements ControllerVisitor {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
    }

    @Override
    public void visit(MoveController moveController) {
        new PlayMenu(moveController).execute();
        new GameView(moveController).writeln();
    }

    @Override
    public void visit(ResumeController resumeController) {
        if (new YesNoDialog().read(Message.RESUME.toString())){
            resumeController.resume();
        }
    }

}
