package src.ui;

import src.model.warehous.WarehouseType;
import src.presenter.Presenter;

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

    @Override
    public void print(String text) {
        System.out.println(text);

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

    public void reqCreateWarehouse() {
        String warehouseName = reqNameOfWarehouse();
        WarehouseType type = reqTypeOfWarehouse();
        if (presenter.addWarehouse(warehouseName, type)){
            print("Склад успешно добавлен");
        }else print("Не удалось добавить склад");
    }

    public void reqAddBookToWarehouse() {
        print("Выберите существующий склад игрушек для добавления товара");

    }

    public boolean reqSave(){
        print("Для сохранения введите имя магазина");
        return presenter.save(scan());
    }

    public boolean reqLoadShops(){
        String answer = presenter.getShopList();
        if(!answer.equals("Пока не создано ни одного магазина.")){
            print("Введите имя магазина для загрузки");
            System.out.println(presenter.getShopList());
            return presenter.load(scan());
        }else print("Список магазинов пуст! \n");
        return false;
    }

    public boolean reqPrintWarehouses(){
        return presenter.printWarehouses();
    }

    public void reqShopList(){
        System.out.println(presenter.getShopList());
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
