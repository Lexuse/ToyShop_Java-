package src.ui.consoleComands;

import src.ui.Console;

public class WarehousesSave extends Command{

    public WarehousesSave(Console console) {
        super(console);
        descriptionCommand = "Сохранить склады";
    }

    @Override
    public boolean executeCommand() {
        return null;
    }
}
