import model.goods.toy.ToyCreate;
import model.goods.toy.ToysStore;
import model.goods.toy.TypeOfToy;
import model.warehous.WarehouseType;
import model.warehous.Warehouses;

public class Program {
    public static void main (String[] args){
//        ToyCreate toyCreater;
//        ToysStore toystore = new ToysStore();
//        toyCreater = new ToyCreate(TypeOfToy.Кукла, "Барби", 60, 3);
//        //System.out.println(toystore.toString());
        Warehouses war = new Warehouses();
        war.addWarehouse("Склад 1", WarehouseType.Книги);
        war.addWarehouse("Склад 2", WarehouseType.Игрушки);

        System.out.println(war.warehousesInfo());
    }
}
