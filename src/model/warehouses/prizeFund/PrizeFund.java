package src.model.warehouses.prizeFund;

import src.model.Product;
import src.model.warehous.InterfaceWarehouse;
import src.model.warehous.ProductIterator;
import src.model.warehous.Warehouse;
import src.model.warehous.WarehouseType;
import src.model.warehouses.Warehouses;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class PrizeFund <E extends Product> implements InterfaceWarehouse, Serializable {
    private String name = "Призовой";
    WarehouseType type = WarehouseType.ПРИЗОВОЙ;
    private List<E> products;
    private static int iD = 2222;
    private final Warehouses<Warehouse> warehouses = new Warehouses<>();

    public PrizeFund(){
        iD++;
    }

    @Override
    public void setName(String name) {
        this.name =name;
    }

    public void setType(WarehouseType type) {this.type = type;}

    public String getName() {return name;}

    public WarehouseType getType() {return type;}

    public int getID() {return iD;}

    public List<E> getProducts(){
        return this.products;
    }

    public boolean addProduct(E product){return getProducts().add(product);}

    public String getProductsList(){
        String result = "";
        if (products.size() != 0) {
            int number = 0;
            for (Product product : products) {
                number++;
                result += number + ": " + product.toString() + "\n";
            }
        }return result;
    }
    @Override
    public String toString(){
        return "Название склада: " + this.getName() + "\n" +
                "Тип склада: Призовой"  + "\n" +
                "ИД склада: " + getID() + "\n";
    }

    @Override
    public Iterator<E> iterator() {
        return new ProductIterator<>(products);
    }

    public boolean giveOutPrize(String name){
        if (products.size() != 0){
            for (Product product : products){
                if (product.getName().equals(name)){
                    products.remove(product);
                }
            }
        }return true;
    }


}
