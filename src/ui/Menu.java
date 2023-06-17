package src.ui;

import src.ui.consoleComands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commands;
    private final List<Command> editWarehousesCommands;
    private int countAppearance = 0;

    public Menu(Console console){
        commands = new ArrayList<>();
        commands.add(new getAllShops(console));//Вывести список магазинов
        commands.add(new LoadWarehouse(console));//Загрузить магазин
        commands.add(new PrintWarehouses(console));//Посмотреть имеющиеся склады магазина
        commands.add(new SaveWarehouses(console));//Сохранить магазин
        commands.add(new Quit(console));//Выйти из программы


        editWarehousesCommands = new ArrayList<>();
        editWarehousesCommands.add(new WarehouseCreate(console));//Добавить новый склад);
        editWarehousesCommands.add(new AddToyToWarehouse(console));//Добавить игрушку на склад
        editWarehousesCommands.add(new AddBookToWarehouse(console));//Добавить книгу на склад
        editWarehousesCommands.add(new PrintWarehouse(console));//Распечатать содержимое склада
        editWarehousesCommands.add(new QuitMenu(console));//Покинуть пункт меню
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
        countAppearance++;
        StringBuilder result = new StringBuilder();
        if (countAppearance ==1){
            result.append("""
                    *************************************************************************
                    Добро пожаловать в программу 'Менеджер магазинов детских товаров'!
                    Вам доступно создание и загрузка магазинов а также менеджмент их складов.
                    Загрузите магазин или создайте свой, добавив товары и склады
                    *************************************************************************
                    """);
        }
        for (int i = 0; i < commands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(commands.get(i).getDescriptionCommand()).append("\n");
        }
        return result.toString();
    }

    public String printEditWarehouse() {
        StringBuilder result = new StringBuilder();
        result.append("Введите что хотите сделать со складом:\n");
        for (int i = 0; i < editWarehousesCommands.size(); i++) {
            result.append(String.format("%d. ", i + 1));
            result.append(editWarehousesCommands.get(i).getDescriptionCommand()).append("\n");
        }
        return result.toString();
    }
}
