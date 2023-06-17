package src.ui.consoleComands;

import src.ui.Console;

import java.io.IOException;

public class PrintWarehouses extends Command{
    public PrintWarehouses(Console console){
        super(console);
        descriptionCommand = "Посмотреть имеющиеся склады магазина";
    }

    @Override
    public boolean executeCommand() throws IOException {
        getConsole().reqPrintWarehouses();
        return true;
    }

}
