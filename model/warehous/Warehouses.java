package model.warehous;

import java.util.ArrayList;
import java.util.List;

public class Warehouses {
    private List<Warehouse> warehouses = new ArrayList<>();
    Warehouse warehouse;

    public void addWarehouse (String name, WarehouseType type){
        warehouse = new Warehouse(name, type);
        warehouses.add (warehouse);

    }

    public String warehousesInfo(){
        StringBuilder result = new StringBuilder();
        result.append("Количество имеющихся складов: " + warehouses.size() + "\n");
        for (Warehouse war : warehouses){
            result.append("Название " + warehouses.indexOf(warehouse) + "-го " + "склада "  + ": " + warehouse.getName()+ "\n");
            result.append("Тип " + warehouses.indexOf(warehouse)+ "-го " +  "склада " + ": " + warehouse.getType() + "\n");
            result.append("ИД " + warehouses.indexOf(warehouse)+ "-го " + "склада " + ": " + warehouse.getiD() + "\n" + "\n");
        }
        return result.toString();
    }



}