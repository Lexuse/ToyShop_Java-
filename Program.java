import model.warehous.WarehouseType;
import model.warehous.Warehouses;

public class Program {
    public static void main (String[] args){
//        ToyCreate toyCreater;
//        ToysStore toystore = new ToysStore();
//        toyCreater = new ToyCreate(TypeOfToy.Кукла, "Барби", 60, 3);
//        //System.out.println(toystore.toString());
        Warehouses war = new Warehouses();
        war.addWarehouse("Томск", WarehouseType.Игрушки);
        war.addWarehouse("На речной", WarehouseType.Книги);

        System.out.println(war.warehousesInfo());
    }
}
