package model.warehous;

import java.util.ArrayList;
import java.util.List;

public class Warehouses {
    private List<Warehouse> warehouses = new ArrayList<>();
    Warehouse warehouse;

    public void addWarehouse (Warehouse war){
        warehouses.add (war);

    }

    public String warehousesInfo(){
        StringBuilder result = new StringBuilder();
        result.append("Количество имеющихся складов: " + warehouses.size() + "\n");
        for (int i = 0; i < warehouses.size() ; i++) {
            result.append(warehouse.toString());
        }
        return result.toString();
    }



}