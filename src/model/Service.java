package src.model;

import src.model.fileManager.FileManager;
import src.model.goods.books.Book;
import src.model.goods.books.TypeOfBook;
import src.model.goods.toy.Toy;
import src.model.goods.toy.TypeOfToy;
import src.model.warehous.Warehouse;
import src.model.warehous.WarehouseType;
import src.model.warehouses.InterfaceWarehouses;
import src.model.warehouses.Warehouses;

public class Service {

    private Warehouse<Product> warehouse;

    private InterfaceWarehouses<Warehouse> warehouses;
    FileManager fl = new FileManager();

    public Service() {
        new Warehouses();
    }

    public Service(InterfaceWarehouses warehouses) {
        this.warehouses = warehouses;
    }

    public InterfaceWarehouses<Warehouse> getWarehouses() {
        return new Warehouses();
    }

    //Добавить склад
    public boolean addWarehouse(String name, WarehouseType type){
        warehouse = new  Warehouse<Product>(name, type);
        return this.getWarehouses().addWarehouse(warehouse);
    }

    public boolean addToy(TypeOfToy type, String name, int weightWin, String nameOfWarehouse){
        Product toy = new Toy(type, name ,weightWin);
        if (warehouses != null){
            for (Warehouse war :warehouses){
                if(nameOfWarehouse.equals(war.getName()) && war.getType().equals(WarehouseType.Toys)){
                    return war.addProduct(toy);
                }
            }
        }return false;
    }

    public boolean addBook(TypeOfBook type, String name, String author, int weighWin, String nameOfWarehouse){
        Product book = new Book(type, name, author, weighWin);
        if (warehouses != null){
            for (Warehouse war :warehouses){
                if(nameOfWarehouse.equals(war.getName()) && war.getType().equals(WarehouseType.Books)){
                    return war.addProduct(book);
                }
            }
        }return false;
    }

    public String printInfoAllWarehouses(){
        return this.getWarehouses().printInfoAll();
    }
    public String printWarehouses(){
        return this.getWarehouses().printWarehouses();
    }

    public Warehouses geyToyWarehouses(){
        return this.geyToyWarehouses();
    }

    public Warehouses getBookWarehouses(){
        return this.getBookWarehouses();
    }

    public void save(String fileName){
        FileManager<Warehouses<Warehouse>> fileManager = new FileManager<>();
        this.getWarehouses().save(fileManager, fileName);
    }

    public  Warehouses<Warehouse> read (String fileName){
        FileManager<Warehouses> fileManager = new FileManager<>();
        return fileManager.read(fileName);
    }

    public String getShopsList(){
        return fl.getShopsList();
    }

    public String getProductsList(){
        return warehouse.getProductsList();
    }
}
