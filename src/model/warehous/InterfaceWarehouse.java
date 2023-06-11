package src.model.warehous;

import java.util.List;

public interface InterfaceWarehouse<E extends Warehouse> extends Iterable{

    void setName(String name);
    void setType(WarehouseType type);
    String getName();
    WarehouseType getType();
    int getID();
    List<E> getProducts();

}
