package usantatecla.utils;

import java.util.ArrayList;

public abstract class Menu {

    private static final String OPTION = "Choose an option: ";
    private ArrayList<Command> commandList;

    public Menu() {
        this.commandList = new ArrayList<Command>();
        for (int i = 0; i < this.commandList.size(); i++) {
            this.commandList.add(this.commandList.get(i));
        }
    }

    public void execute() {
        boolean error;
        int option;
        do {
            error = false;
            for (int i = 0; i < this.commandList.size(); i++) {
                Console.getInstance().writeln((i + 1) + ") " + this.commandList.get(i).getTitle());
            }
            Console.getInstance().write(OPTION);
            option = Console.getInstance().readInt("") - 1;
            if (!new ClosedInterval(0, this.commandList.size() - 1).isIncluded(option)) {
                error = true;
            }
            Console.getInstance().writeln();
        } while (error);
        this.commandList.get(option).execute();
    }

    protected void addCommand(Command command) {
        this.commandList.add(command);
    }

}
