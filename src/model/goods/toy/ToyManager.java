package src.model.goods.toy;

public class ToyManager {
    ToysStore toysStore = new ToysStore();

    public ToyManager(TypeOfToy type, String name, int weightWin, int amount) {
        Toy toy = new Toy(type, name, weightWin);
        toysStore.AddToyToStore(toy,amount);
    }
}
