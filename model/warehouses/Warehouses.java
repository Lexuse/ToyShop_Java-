package model.warehouses;

import model.fileManager.Writable;
import model.warehous.Warehouse;

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
        result.append("Количество складов: " + warehouses.size());
        for (E warehouse : warehouses){
            result.append(warehouse.getName());
        }
        return result.toString();
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
    public void save(Writable writable, String fileName) {

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
