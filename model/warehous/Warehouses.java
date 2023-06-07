package model.warehous;

import java.util.ArrayList;
import java.util.List;

public class Warehouses {
    private List<Warehouse> warehouses = new ArrayList<>();

    public void addWarehouse (String name, WarehouseType type){
        warehouses.add (new Warehouse(name, type));
    }

    public String warehousesInfo(Warehouse warehouse){
        StringBuilder result = new StringBuilder();
        Warehouse Warehouse = new Warehouse(warehouse.getName(), warehouse.getType());
        for (Warehouse war : warehouses){
            result.append(Warehouse.getName()).append("/n");
            result.append(Warehouse.getType()).append("/n");
            result.append(Warehouse.getiD()).append("/n");
        }
        return result.toString();
    }



}