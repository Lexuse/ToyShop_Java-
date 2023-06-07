package model;

import model.toy.TypeOfToy;

public interface Product {

    ProductType getProductType();
    String getName();
    int getWeightWin();
    int getSerialNumber();
    String toString();
}
