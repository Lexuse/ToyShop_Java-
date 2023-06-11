package src.model.warehouses;

import java.util.Iterator;
import java.util.List;

public class IteratorWarehouses<E> implements Iterator<E> {
    private int index;
    private List<E> warehouses;

    public IteratorWarehouses(List<E> warehouses) {
        this.warehouses = warehouses;
    }

    @Override
    public boolean hasNext(){
        return index < this.warehouses.size();
    }

    @Override
    public E next(){
    return this.warehouses.get(index++);
    }
}
