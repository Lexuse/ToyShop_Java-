package model.toy;

import java.util.ArrayList;
import java.util.List;

public class ToysStore {
    private List<Toy> toyStore = new ArrayList<Toy>();

    public void AddToyToStore(Toy toy, int amount){
        if(amount != 0){
            for (int i = 0; i <= amount ; i++) {
                toyStore.add(toy);
            }
        }
        toString();
    }
}