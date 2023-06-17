package src.ui;

import src.model.goods.books.TypeOfBook;
import src.model.goods.toy.TypeOfToy;
import src.model.warehous.WarehouseType;
import src.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;
import java.util.SortedMap;

public class Console implements  View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean isWork;
    private Menu menu;

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
    public void start(){
        while (isWork){
            mainRequest();
        }
    }

    private void mainRequest() {
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
        try {
            presenter.addWarehouse(warehouseName, warehouseType);
        }catch (NullPointerException ex) {
            print("Укажите пожалуйста правильный тип склада");
            reqCreateWarehouse();
        }
        return true;
    }

    public boolean reqSave(){
        print("Для сохранения введите имя магазина");
        return presenter.save(scan());
    }

    public boolean reqLoadShops(){
        String answer = presenter.getShopList();
        if(!answer.equals("Файл со списком магазинов пока отсутствует, сохраните магазин. \n")){
            //print("Введите имя магазина для загрузки");
            System.out.println(presenter.getShopList());
            return presenter.load(scan());
        }else print("Список магазинов пуст!\n" +
                "Для продолжения работы нужно сначала создать магазин.\n");
        return true;
    }

    public boolean reqPrintWarehouses() {
        if (!(presenter.printWarehouses())) {
            print("Нет складов, или магазин не загружен!\n" +
                    "Сначала загрузите магазин, в котором имеются склады.\n");
        } else {
            presenter.printWarehouses();
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
        return presenter.addToy(type, name, weightWin, nameOfWarehouse);
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
            }
        }
        print("Вы ввели несуществующий тип склада. Возврат в основное меню!\n");
        mainRequest();
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
