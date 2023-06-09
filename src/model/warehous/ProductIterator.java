package src.model.warehous;

import src.model.Product;

import java.util.Iterator;
import java.util.List;

public class ProductIterator<E extends Product> implements Iterator {
    private int index;
    private final List<E> products;

    public ProductIterator(List<E> products) {
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return index < this.products.size();
    }

    @Override
    public E next() {
        return this.products.get(index++);
    }
}
