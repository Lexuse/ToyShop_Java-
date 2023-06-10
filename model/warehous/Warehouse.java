package model.warehous;

import model.Product;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class Warehouse<E extends Product> implements InterfaceWarehouse, Serializable {
    private String name;
    WarehouseType type;
    private List<E> products;
    private static int iD = 5555;

    Warehouse(String name, WarehouseType type) {
        this.name = name;
        this.type = type;
        iD += 1;
    }

    public <E extends Product> boolean addProduct(E product) {
        return this.getProducts().add(product);
    }

    public E findProduct(String name){
        for (E product : this.getProducts()){
            if (product.getName().equals(name)){
                return  product;
            }
        }
    }

    public void setName(String name){this.name =name;}
    public void setType(WarehouseType type){this.type = type;}

    public String getName() {
        return name;
    }
    public WarehouseType getType() {
        return type;
    }
    public  int getID() {
        return iD;
    }
    public List getProducts() {return this.products;}

    @Override
    public String toString(){
         return "Название склада: " + this.getName() + "\n" +
                 "Тип склада: " + this.getType() + "\n" +
                 "ИД склада: " + getID() + "\n";
    }


    @Override
    public Iterator iterator() {
        return null;
    }
}
