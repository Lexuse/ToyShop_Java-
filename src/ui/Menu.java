package src.ui;

import src.ui.consoleComands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;
    private List<Command> editWarehousesCommands;

    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new getAllShops(console));//Вывести список магазинов
        commands.add(new LoadWarehouse(console));//Загрузить магазин
        commands.add(new PrintWarehouses(console));//Посмотреть имеющиеся склады магазина
        commands.add(new WarehouseCreate(console));//Добавить новый склад
        //commands.add(new EditWarehouse(console));
        commands.add(new SaveWarehouses(console));//Сохранить магазин
        commands.add(new Quit(console));//Выйти из программы


        editWarehousesCommands = new ArrayList<>();
        editWarehousesCommands.add((new AddToyToWarehouse(console)));
        editWarehousesCommands.add((new AddBookToWarehouse(console)));
        editWarehousesCommands.add(new PrintWarehouse(console));
        editWarehousesCommands.add(new QuitMenu(console));
    }

    public int getSizeMainCommands() {
        return commands.size();
    }
    public int getSizeEditWarehousesCommands() {return editWarehousesCommands.size();    }
    public boolean executeMainCommands(int nMenu) {
        return commands.get(nMenu - 1).executeCommand();
    }
    public int editWarehousesCommands() {
        return editWarehousesCommands.size();
    }
    public boolean executeEditTreeCommands(int nMenu) {
        return editWarehousesCommands.get(nMenu - 1).executeCommand();
    }

    public String printMainCommands() {
        StringBuilder result = new StringBuilder();
        result.append("Выберите операцию над Магазинами:\n");
        for (int i = 0; i < commands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(commands.get(i).getDescriptionCommand() + "\n");
        }
        return result.toString();
    }

    public String printEditWarehouse() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать со складом:\n");
        for (int i = 0; i < editWarehousesCommands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(editWarehousesCommands.get(i).getDescriptionCommand() + "\n");
        }
        return result.toString();
    }
}
