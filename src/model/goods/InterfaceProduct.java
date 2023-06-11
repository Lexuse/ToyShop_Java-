package src.model.goods;

import src.model.ProductType;

public interface InterfaceProduct {
    ProductType getProductType();
    String getName();
    int getWeightWin();
    int getSerialNumber();

    default String print(){
        if (this !=null){
            return "Информация о товаре: ";
        }else {
            return "";
        }
    }

    default String getTypeOfProduct(){
        if (this.getProductType().equals(getProductType().Toys)){
            return this.print() + "Игрушка. ";
        }else if (this.getProductType().equals(getProductType().Books)){
            return this.print() + "Книга. ";
        }else return  "Тип товара не указан";
    }

    default String printInfo(){
        if(this != null){
            StringBuilder result = new StringBuilder();
            result.append(print() + "\n");
            result.append(getTypeOfProduct() + "\n");
            result.append(this.toString());
            return result.toString();
        }else return "";
    }

}
