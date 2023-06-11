package src.model.goods.toy;

import src.model.Product;
import src.model.ProductType;
import java.io.Serializable;

public class Toy implements Product, Serializable {
    private ProductType productType;
    private TypeOfToy type;
    private String name;
    private int weightWin;
    private static int serialNumber = 1111;


    public Toy(TypeOfToy type ,String name, int weightWin) {
        this.productType =ProductType.Toys;
        this.type = type;
        this.name = name;
        if(weightWin >=0 && weightWin <=100) {
            this.weightWin = weightWin;
        }
        else this.weightWin = 50;
        serialNumber += 1;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
    public String getName() {
        return name;
    }
    public int getWeightWin() {
        return weightWin;
    }
    public TypeOfToy getType() {
        return type;
    }
    public ProductType getProductType() {return productType;}

    @Override
    public String toString() {
        return  "Тип игрушки: " + this.getType() + "\n" +
                "Имя игрушки: " + this.getName() + "\n" +
                "Шанс выиграть игрушку :" + this.getWeightWin() + "\n" +
                "Серийный номер: " + this.getSerialNumber();
    }
}