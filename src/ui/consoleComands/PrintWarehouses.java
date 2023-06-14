package src.ui.consoleComands;

import src.ui.Console;

public class PrintWarehouses extends Command{
    public PrintWarehouses(Console console){
        super(console);
        descriptionCommand = "Посмотреть имеющиеся склады";
    }

    @Override
    public boolean executeCommand(){
        getConsole().reqPrintWarehouses();
        return true;
    }

}
