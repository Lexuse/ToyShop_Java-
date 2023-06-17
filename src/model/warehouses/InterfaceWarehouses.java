package src.model.warehouses;

import src.model.fileManager.Writable;
import src.model.warehous.Warehouse;

import java.io.IOException;
import java.util.List;

public interface InterfaceWarehouses <E extends Warehouse> extends Iterable<E>{

    boolean addWarehouse(E warehouse);
    List<E> getWarehouses();
    String printWarehouses();
    String printInfoAll();
    void save(Writable<Warehouses<E>> writable, String fileName) throws IOException;
}
