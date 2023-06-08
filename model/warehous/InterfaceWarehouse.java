package model.warehous;

import model.fileManager.Writable;

import java.util.List;

public interface InterfaceWarehouse<E extends Warehouse> extends Iterable{

    boolean addWarehouse(E warehouse);
    E findWarehouse(String name);
    String printWarehouses();
    String printAllInfo();
    void save(Writable<Warehouses<E>> writable, String fileName);
    List<E> getWarehouses();

}
