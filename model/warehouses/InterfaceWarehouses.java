package model.warehouses;

import model.fileManager.Writable;
import model.warehous.Warehouse;

import java.util.List;

public interface InterfaceWarehouses <E extends Warehouse> extends Iterable<E>{

    boolean addWarehouse(E warehouse);
    List<E> getWarehouses();
    String printWarehouses();
    String printInfoAll();
    void save(Writable<Warehouses<E>> writable, String fileName);
}
