package model;

import model.fileManager.FileManager;
import model.goods.books.Book;
import model.goods.books.TypeOfBook;
import model.goods.toy.Toy;
import model.goods.toy.TypeOfToy;
import model.warehous.Warehouse;
import model.warehous.WarehouseType;
import model.warehouses.InterfaceWarehouses;
import model.warehouses.Warehouses;

public class Service {

    private Warehouse<Product> warehouse;
    private InterfaceWarehouses<Warehouse> warehouses;

    public Service() {
        this(new Warehouses<>());
    }
    public Service(InterfaceWarehouses warehouses) {
        this.warehouses = warehouses;
    }
    public InterfaceWarehouses<Warehouse> getWarehouses() {
        return this.warehouses;
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

    public void save(String fileName){
        FileManager<Warehouses<Warehouse>> fileManager = new FileManager<>();
        this.getWarehouses().save(fileManager, fileName);
    }

    public  Warehouses<Warehouse> read (String fileName){
        FileManager<Warehouses> fileManager = new FileManager<>();
        return fileManager.read(fileName);
    }

}
