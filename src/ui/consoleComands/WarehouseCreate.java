package src.ui.consoleComands;

import src.ui.Console;

public class WarehouseCreate extends Command{

    public WarehouseCreate(Console console) {
        super(console);
        descriptionCommand = "Добавить новый склад";
    }

    @Override
    public boolean executeCommand() {
        return false;
    }
}
