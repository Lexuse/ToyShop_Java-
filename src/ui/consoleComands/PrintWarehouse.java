package src.ui.consoleComands;

import src.ui.Console;

public class PrintWarehouse extends Command {
    public PrintWarehouse(Console console){
        super(console);
        descriptionCommand = "Распечатать содержимое склада";
    }

    @Override
    public boolean executeCommand(){
        getConsole().reqPrintWarehouse();
        return true;
    }
}
