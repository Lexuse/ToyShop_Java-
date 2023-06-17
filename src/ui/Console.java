package src.ui;

import src.model.goods.books.TypeOfBook;
import src.model.goods.toy.TypeOfToy;
import src.model.warehous.WarehouseType;
import src.presenter.Presenter;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Console implements  View{
    private Presenter presenter;
    private final Scanner scanner;
    private boolean isWork;
    private final Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        isWork =true;
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException {
        while (isWork){
            mainRequest();
        }
    }

    private void mainRequest() throws IOException {
        print(menu.printMainCommands());
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (0 < nMenu && nMenu <= menu.getSizeMainCommands()) {
                menu.executeMainCommands(nMenu);
            } else {
                print("Некорректный ввод");
            }
        } else {
            print("вводите цифры обозначающие пункты меню");
        }
    }

    public boolean reqCreateWarehouse() {
        print("Режим создания нового склада!");
        print("Для создания доступны следующие типы:");
        print(WarehouseType.String());
        print("Укажите желаемый тип: (указывается вводом с клавиатуры текста)");
        WarehouseType warehouseType =  reqTypeOfWarehouse(scan());
        String warehouseName = reqNameOfWarehouse();
        print("Склад с название " + "'" +  warehouseName + "'" + ". Тип: " + warehouseType.toString() + " - успешно добавлен.\n");
        return presenter.addWarehouse(warehouseName, warehouseType);
    }

    public boolean reqSave() throws IOException {
        print("Для сохранения введите имя магазина");
        return presenter.save(scan());
    }

    public boolean reqLoadShops(){
        String answer = presenter.getShopList();
        if(!answer.equals("Пока не сохранено ни одного магазина \n")){
            System.out.println(presenter.getShopList());
            return presenter.load(scan());
        }else print("""
                Список магазинов пуст!
                Для продолжения работы нужно сначала создать магазин.
                """);
        return true;
    }

    public boolean reqPrintWarehouses() throws IOException {
        if (!(presenter.printWarehouses())) {
            print("""
                    Нет складов, или магазин не загружен!
                    Сначала загрузите магазин, в котором имеются склады.
                    """);
        } else {
            print(menu.printEditWarehouse());
            String nMenuStr = scan();
            if (isCanBeInt(nMenuStr)) {
                int nMenu = Integer.parseInt(nMenuStr);
                if (0 < nMenu && nMenu <= menu.getSizeEditWarehousesCommands()) {
                    return menu.executeEditTreeCommands(nMenu);
                } else {
                    print("Некорректный ввод");
                }
            } else {
                print("вводите цифры обозначающие пункты меню");
            }

        }return true;
    }

    public boolean reqPrintWarehouse(){
         print("Какой склад показать?");
         print(presenter.getProductsList(scan()));
         return true;
    }

    public void reqShopList(){
        System.out.println(presenter.getShopList());
    }

    public boolean reqAddToy(){
        print("Выберите существующий склад с игрушками для добавления экземпляра:");
        String nameOfWarehouse = reqNameOfWarehouse();
        print("Тип игрушки:");
        print(TypeOfToy.String());
        TypeOfToy type = reqTypeOfToy(scan());
        print("имя игрушки:");
        String name = scan();
        print("Шанс выиграть игрушку:");
        int weightWin = reqChanceToWin();
        if (presenter.addToy(type, name, weightWin, nameOfWarehouse)) {
            print(type.toString().toLowerCase(Locale.ROOT) + " '" + name + "'" + " успешно добавлено на склад " + nameOfWarehouse + "\n");
        }

        return true;
    }

    public boolean reqAddBookToWarehouse() {
        print("Выберите существующий склад с книгами для добавления экземпляра. Выбор происходит методом ввода с клавиатуры.");
        String nameOfWarehouse = reqNameOfWarehouse();
        print("Жанр книги:");
        print(TypeOfBook.String());
        TypeOfBook bookGenre = reqTypeOfBook(scan());
        print("Автор книги:");
        String author = scan();
        print("Название книги:");
        String name = scan();
        print("Шанс выиграть книгу:");
        int weightWin = reqChanceToWin();
        return presenter.addBook(bookGenre, name, author, weightWin, nameOfWarehouse);
    }

    private  WarehouseType reqTypeOfWarehouse(String name){
        return getEnumFromString(WarehouseType.class, name);
    }

    private  TypeOfBook reqTypeOfBook(String name) {
        return getEnumFromString(TypeOfBook.class, name);
    }

    private  TypeOfToy reqTypeOfToy(String name){
        return getEnumFromString(TypeOfToy.class, name);
    }

    public  <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if( c != null && string != null ) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
                print("Вы ввели несуществующий тип. Возврат в меню!\n");
            }
        }
        print(menu.printEditWarehouse());
        return null;
    }

    private int reqChanceToWin (){
        print("Укажите шанс выигрыша от 0 до 99 \n");
        String chance = scan();
        int resultOut = 0;
        if (isCanBeInt(chance)){
            resultOut = Integer.parseInt(chance);
            if (resultOut >=0 && resultOut <= 99){
                return resultOut;
            }else print("Введите число от 0 до 99!");
            reqChanceToWin();
        }return resultOut;
    }

    //Запрос имени склада
    public String reqNameOfWarehouse(){
        print("Введите название склада: ");
        return scan();
    }

    public String scan(){return scanner.nextLine();}

    private boolean isCanBeInt(String text) {
        return text.matches("[0-9]+");
    }

    public void quit() {isWork = false;}

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
