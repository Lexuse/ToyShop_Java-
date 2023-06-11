package src.ui.consoleComands;

import src.ui.Console;

public abstract class Command {

    String descriptionCommand;
    private final Console console;

    public Command(Console console){
        this.console = console;
    }

    public String getDescriptionCommand() {
        return descriptionCommand;
    }

    public Console getConsole(){
        return console;
    }

    public abstract boolean executeCommand();
}
