package src.ui;

import src.model.goods.toy.Toy;
import src.model.goods.toy.TypeOfToy;
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
        String typeIn = reqTypeOfWarehouse();
        WarehouseType type = WarehouseType.Books;
        if (typeIn.equals("Toys")){
            type = WarehouseType.Toys;
        }
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
        if(answer.equals("Пока не создано ни одного магазина.")){
            print("Введите имя магазина для загрузки");
            System.out.println(presenter.getShopList());
            return presenter.load(scan());
        }else print("Список магазинов пуст!\n" +
                "Для продолжения работы нужно сначала создать магазин\n");
        return false;
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
         presenter.getProductsList();
         return true;
    }

    public void reqShopList(){
        System.out.println(presenter.getShopList());
    }



    //Запрос имени склада
    public String reqNameOfWarehouse(){
        print("Введите название склада: ");
        return scan();
    }
    public String reqTypeOfWarehouse() {
        String result = "";
        print("Укажите тип склада:");
        print("1: Игрушки\n2: Книги");
        String nMenuStr = scan();
        if (isCanBeInt(nMenuStr)) {
            int nMenu = Integer.parseInt(nMenuStr);
            if (nMenu > 0 && nMenu <=2) {
                if (nMenu == 1) {
                    result = "Toys";
                }
            }else if (nMenu ==2) {
                    result = "Books";
            } else print("Некорректный ввод!");
        }
        return result;
    }

    public boolean addToy(){
        String nameOfWarehouse = reqNameOfWarehouse();
        String type = reqTypeOfToy();
        TypeOfToy t = TypeOfToy.valueOf(type);
        String name = reqNameOfToy();
        int weightWin = reqChanceToWin();
        presenter.addToy(t, name, weightWin, nameOfWarehouse);
        return true;
    }

    private String reqTypeOfToy(){
        List<String> typeOfToy = presenter.getTypeOfToy();
        StringBuilder result = new StringBuilder();
        for (String type : typeOfToy){
            result.append(type);
            result.append("\n");
        }
        print(result.toString());
        print("Укажите тип игрушки из списка возможных \n");
        return scan();
    }

    private String reqNameOfToy(){
        print("Укажите название игрушки \n");
        return scan();
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
}
