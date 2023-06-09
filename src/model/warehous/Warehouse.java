package src.model.warehous;

import src.model.Product;
import src.model.warehouses.Warehouses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warehouse<E extends Product> implements InterfaceWarehouse, Serializable {
    private String name;
    WarehouseType type;
    private final List<E> products;
    private static int iD = 5555;

    public Warehouse(String name, WarehouseType type) {
        this.name = name;
        this.type = type;
        iD += 1;
        Warehouses<Warehouse> warehouses = new Warehouses<>();
        warehouses.addWarehouse(this);
        this.products = new ArrayList<>();
    }

    public boolean addProduct(E product) {
        //System.out.println("CONSOLE: Вызван метод добавления продукта в складе (Warehouse)");;
        return  this.getProducts().add(product);
    }

    public E findProduct(String name){
        for (E product : this.getProducts()){
            if (product.getName().equals(name)){
                return  product;
            }
        }return null;
    }

    public void setName(String name){this.name =name;}
    public void setType(WarehouseType type){this.type = type;}

    public String getName() {return name;}
    public WarehouseType getType() {return type;}
    public  int getID() {return iD;}
    public List<E> getProducts() {return this.products;}

    public String getProductsList(){
        StringBuilder result = new StringBuilder();
        if (products.size() != 0) {
            int number = 0;
            for (Product product : products) {
                number++;
                result.append(number).append(": ").append(product.toString()).append("\n");
            }
        }return result.toString();
    }

    @Override
    public String toString(){
         return "Название склада: " + this.getName() + "\n" +
                 "Тип склада: " + this.getType() + "\n" +
                 "ИД склада: " + getID() + "\n";
    }

    @Override
    public Iterator<E> iterator() {
        return new ProductIterator<>(products);
    }

}
