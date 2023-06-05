package model;

import java.util.ArrayList;
import java.util.List;

public class ToyStore {
    private List<Toy> toyStore = new ArrayList<Toy>();

    public void AddToyToStore(Toy toy, int amount){
        if(amount != 0){
            for (int i = 0; i <= amount ; i++) {
                toyStore.add(toy);
            }
        }
        toString();
    }

    //public ToyStore(List<Toy> toyStore) {
    //    this.toyStore = toyStore;
    //}

    @Override
    public String toString(){
        StringBuilder str =new StringBuilder();
        for (Toy toys: toyStore){
            str.append(toys.toString());
        }
        return str.toString();
    }

}
