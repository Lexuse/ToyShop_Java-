package src.ui.consoleComands;

import src.ui.Console;

public class AddBookToWarehouse extends Command{
    public AddBookToWarehouse(Console console){
        super(console);
        descriptionCommand = "Добавить книгу на склад";
    }

    @Override
    public boolean executeCommand(){
        getConsole().reqAddBookToWarehouse();
        return true;
    }
}
