package src.ui.consoleComands;

import src.ui.Console;

import java.io.IOException;

public class SaveWarehouses extends Command{
    public SaveWarehouses(Console console){
        super(console);
        descriptionCommand = "Сохранить магазин";
    }

    @Override
    public boolean executeCommand() throws IOException {
        getConsole().reqSave();
        return true;
    }
}
