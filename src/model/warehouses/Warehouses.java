package src.model.warehouses;

import src.model.fileManager.Writable;
import src.model.warehous.Warehouse;
import src.model.warehous.WarehouseType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warehouses <E extends Warehouse> implements InterfaceWarehouses<E>, Serializable {

    private List<E> warehouses;

    public Warehouses(){this.warehouses = new ArrayList<>();}

    public List<E> getWarehouses(){return this.warehouses;}

    public boolean addWarehouse(E warehouse){return this.getWarehouses().add(warehouse);}

    public String printWarehouses() {
        StringBuilder result = new StringBuilder();
        result.append("Количество складов: " + warehouses.size() + "\n");
        for (E warehouse : warehouses){
            result.append(warehouse.getName() + ".  Тип склада:" + warehouse.getType().toString() + "\n");
        }
        return result.toString();
    }

    public List<E> geyToyWarehouses(){
        List<E> toyWarehouses = new ArrayList<>();
        if(warehouses.size() != 0) {
            for (E war : warehouses) {
                if (war.getType() == WarehouseType.Toys) {
                    toyWarehouses.add(war);
                }
            }return toyWarehouses;
        } else return null;
    }

    public List<E> getBookWarehouses(){
        List<E> bookWarehouses  = new ArrayList<>();
        if(warehouses.size() != 0) {
            for (E war : warehouses) {
                if (war.getType() == WarehouseType.Books) {
                    bookWarehouses.add(war);
                }
            }return bookWarehouses;
        } else return null;
    }

    @Override
    public String printInfoAll() {
        StringBuilder result = new StringBuilder();
        result.append("Содержимое всех складов: \n");
        for (E warehouse : getWarehouses()){
            result.append(warehouse.toString() + ": \n");
            result.append(warehouse.getProducts().toString());
        }
        return null;
    }

    @Override
    public void save(Writable<Warehouses<E>> writable, String fileName) {
        writable.save(this, fileName);

    }

    @Override
    public Iterator iterator() {
        return new IteratorWarehouses(warehouses);
    }
}
