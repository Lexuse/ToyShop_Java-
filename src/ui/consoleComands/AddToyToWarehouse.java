package src.ui.consoleComands;

import src.ui.Console;

public class AddToyToWarehouse extends Command{
    public AddToyToWarehouse(Console console) {
        super(console);
        descriptionCommand = "Добавить игрушку на склад";
    }

    @Override
    public boolean executeCommand() {
        getConsole().reqAddToy();
        return false;
    }

}
