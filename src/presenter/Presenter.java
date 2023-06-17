package src.presenter;

import src.model.Service;
import src.model.goods.books.TypeOfBook;
import src.model.goods.toy.TypeOfToy;
import src.model.warehous.WarehouseType;
import src.ui.View;

import java.io.IOException;
import java.util.List;

public class Presenter {
    private final View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
        addPrizeFund();
    }

    private boolean addPrizeFund(){
        return addWarehouse("Призовой", WarehouseType.ПРИЗОВОЙ);
    }

    public boolean addWarehouse(String name, WarehouseType type){
        return service.addWarehouse(name, type);
    }

    public boolean addToy(TypeOfToy type, String name, int weightWin, String nameOfWarehouse){
        return  service.addToy(type, name, weightWin, nameOfWarehouse);
    }

    public boolean addBook(TypeOfBook type, String name, String author, int weighWin, String nameOfWarehouse){
        return service.addBook(type, name, author, weighWin, nameOfWarehouse);
    }

    public boolean printWarehouses(){
        try {
            view.print(service.printWarehouses());
            return true;
        }catch (NullPointerException ex){
            return false;
        }


    }

    public boolean printToyWarehouses(){
        view.print(service.printWarehouses());
        return true;
    }

    public boolean printInfoAllWarehouses(){
        service.printInfoAllWarehouses();
        return true;

    }

    public boolean load(String fileName) {
        service = new Service(service.read(fileName));
        return true;
    }

    public boolean save(String fileName) throws IOException {
        service.save(fileName);
        return true;
    }

    public String getShopList(){
        return  service.getShopsList();
    }


    public String getProductsList(String nameOfWarehouse){
        return service.getProductsList(nameOfWarehouse);
    }
}