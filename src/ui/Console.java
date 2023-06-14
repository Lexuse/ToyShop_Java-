package src.ui;

import src.model.goods.books.Book;
import src.model.warehous.WarehouseType;
import src.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

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

    public String scan(){return scanner.nextLine();}
    private boolean isCanBeInt(String text) {
        return text.matches("[0-9]+");
    }
    public void quit() {isWork = false;}


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

    public void createWarehouse() {
        String warehouseName = reqNameOfWarehouse();
        WarehouseType type = reqTypeOfWarehouse();
        if (presenter.addWarehouse(warehouseName, type)){
            print("Склад успешно добавлен");
        }else print("Не удалось добавить склад");
    }

    public void AddBookToWarehouse() {
        print("Выберите существующий склад игрушек для добавления товара");

    }

    public boolean reqSave(){
        print("Для сохранения введите имя магазина");
        return presenter.save(scan());
    }





    //Запрос имени склада
    public String reqNameOfWarehouse(){
        print("Введите название склада: ");
        return scan();
    }
    public WarehouseType reqTypeOfWarehouse() {
        print("Укажите тип склада: \n");
        print("1: Игрушки" + "2: Книги");
        String nMenuStr = scan();
        WarehouseType type = WarehouseType.Toys;
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (1<= nMenu && nMenu <=2) {
                if (nMenu == 1) {
                    type = WarehouseType.Toys;                }
            }else if (nMenu ==2) {
                type = WarehouseType.Books;
            } else print("Некорректный ввод!");
        }
        return type;
    }


}
