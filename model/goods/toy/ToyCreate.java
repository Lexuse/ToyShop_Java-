package model.goods.toy;

public class ToyCreate {
    ToysStore toysStore = new ToysStore();

    public ToyCreate(TypeOfToy type, String name, int weightWin, int amount) {
        Toy toy = new Toy(type, name, weightWin);
        toysStore.AddToyToStore(toy,amount);
    }
}
