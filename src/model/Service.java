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

import java.io.IOException;

public class Service {

    private final InterfaceWarehouses<Warehouse> warehouses;
    FileManager fl = new FileManager();

    public Service() {
        this(new Warehouses());
    }

    public Service(InterfaceWarehouses warehouses) {
        this.warehouses = warehouses;
    }


    public InterfaceWarehouses<Warehouse> getWarehouses() {
        return this.warehouses;
    }

    //Добавить склад
    public boolean addWarehouse(String name, WarehouseType type){
        Warehouse<Product> warehouse = new Warehouse<Product>(name, type);
        return this.getWarehouses().addWarehouse(warehouse);
    }

    public boolean addToy(TypeOfToy type, String name, int weightWin, String nameOfWarehouse){
        Product toy = new Toy(type, name ,weightWin);
        if (warehouses != null){
            for (Warehouse war :warehouses){
                if(nameOfWarehouse.equals(war.getName()) && war.getType().equals(WarehouseType.ИГРУШКИ)){
                    //System.out.println("CONSOLE: (Service) Игрушка добавлена");
                    return war.addProduct(toy);
                }
            }
        }return false;
    }

    public boolean addBook(TypeOfBook type, String name, String author, int weighWin, String nameOfWarehouse){
        Product book = new Book(type, name, author, weighWin);
        if (warehouses != null){
            for (Warehouse war :warehouses){
                if(nameOfWarehouse.equals(war.getName()) && war.getType().equals(WarehouseType.КНИГИ)){
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

    public void save(String fileName) throws IOException {
        FileManager<Warehouses<Warehouse>> fileManager = new FileManager<>();
        this.getWarehouses().save(fileManager, fileName);
    }

    public  Warehouses<Warehouse> read (String fileName){
        FileManager<Warehouses> fileManager = new FileManager<>();
        try {
            return fileManager.read(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getShopsList(){
        return fl.getShopsList();
    }

    public String getProductsList(String nameOfWarehouse){
        for (Warehouse war :this.warehouses)
            if (war.getName().equals(nameOfWarehouse)){
                return war.getProductsList();
            }//else System.out.println("CONSOLE: (Service) Склада с таким именем нет");
        return "Склада с таким именем нет\n";
    }
}
