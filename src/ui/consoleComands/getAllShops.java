package src.ui.consoleComands;

import src.ui.Console;

public class getAllShops extends Command{
    public getAllShops(Console console){
        super(console);
        descriptionCommand = "Вывести список магазинов";
    }
    @Override
    public boolean executeCommand(){
        getConsole().reqShopList();
        return true;
    }
}
