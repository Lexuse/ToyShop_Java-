package src.ui.consoleComands;

import src.ui.Console;

public class SaveWarehouses extends Command{
    public SaveWarehouses(Console console){
        super(console);
        descriptionCommand = "Сохранить магазин";
    }

    @Override
    public boolean executeCommand(){
        getConsole().reqSave();
        return true;
    }
}
