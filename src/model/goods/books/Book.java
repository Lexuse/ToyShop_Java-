package src.model.goods.books;

import src.model.Product;
import src.model.ProductType;
import java.io.Serializable;

public class Book implements Product, Serializable {
    private final ProductType productType;
    private final TypeOfBook type;
    private final String name;
    private final String author;
    private final int weightWin;
    private static int serialNumber = 2222;


    public Book(TypeOfBook type ,String name, String author, int weightWin) {
        this.productType =ProductType.BOOKS;
        this.type = type;
        this.name = name;
        this.author = author;
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
    private String getAuthor() {return this.author; }
    public int getWeightWin() {
        return weightWin;
    }
    public TypeOfBook getType() {
        return type;
    }
    public ProductType getProductType() {return productType;}

    @Override
    public String toString() {
        return  "Жанр книги: " + this.getType() + "\n" +
                "Автор книги: " + this.getAuthor() + "\n" +
                "Название книги: " + this.getName() + "\n" +
                "Шанс выиграть книгу :" + this.getWeightWin() + "\n" +
                "Серийный номер: " + this.getSerialNumber();
    }


}

