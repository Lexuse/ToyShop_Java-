package src.ui.consoleComands;

import src.ui.Console;

public class LoadWarehouse extends Command{
    public LoadWarehouse(Console console){
        super(console);
        descriptionCommand = "Загрузить магазин";
    }
    @Override
    public boolean executeCommand(){
        getConsole().reqLoadShops();
        return true;
    }
}
