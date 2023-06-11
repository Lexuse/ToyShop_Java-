package src.ui;

import src.ui.consoleComands.AddToyToWarehouse;
import src.ui.consoleComands.Command;
import src.ui.consoleComands.WarehouseCreate;
import src.ui.consoleComands.WarehousesSave;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private List<Command> editWarehousesCommands;

    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new WarehouseCreate(console));
        commands.add((new AddToyToWarehouse(console)));
        commands.add(new WarehousesSave(console));

    }
}
