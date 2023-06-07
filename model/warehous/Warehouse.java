package model.warehous;

public class Warehouse {
    private String name;
    WarehouseType type;
    private static int iD = 11;

     Warehouse(String name, WarehouseType type) {
        this.name = name;
        this.type = type;
        iD += 1;
    }

    public String getName() {
        return name;
    }

    public WarehouseType getType() {
        return type;
    }

    public static int getiD() {
        return iD;
    }

}
