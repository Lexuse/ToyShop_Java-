package model.warehous;

import model.fileManager.Writable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Warehouses<E extends Warehouse> implements InterfaceWarehouse, Serializable {
    private List<E> warehouses;

    public Warehouses(){
        this.warehouses = new ArrayList<>();
    }

    public boolean addWarehouse(E warehouse) {
        return this.getWarehouses().add(warehouse);
    }

    @Override
    public List getWarehouses() {
        return this.warehouses;
    }

    @Override
    public Warehouse findWarehouse(String name) {
        return null;
    }

    @Override
    public String printWarehouses() {
        return null;
    }

    @Override
    public String printAllInfo() {
        return null;
    }

    @Override
    public void save(Writable writable, String fileName) {

    }



    @Override
    public Iterator iterator() {
        return null;
    }

    //    private List<Warehouse> warehouses = new ArrayList<>();
//    Warehouse warehouse;
//
//    public void addWarehouse (Warehouse war){
//        warehouses.add (war);
//
//    }
//
//    public String warehousesInfo(){
//        StringBuilder result = new StringBuilder();
//        result.append("Количество имеющихся складов: " + warehouses.size() + "\n");
//        for (int i = 0; i < warehouses.size() ; i++) {
//            result.append(warehouse.toString());
//        }
//        return result.toString();
//    }
//


}