package src.ui.consoleComands;

import src.ui.Console;

public class Quit extends Command{
    public Quit(Console console) {
        super(console);
        descriptionCommand = "Выход из магазина";
    }

    @Override
    public boolean executeCommand() {
        getConsole().quit();
        return false;
    }
}
