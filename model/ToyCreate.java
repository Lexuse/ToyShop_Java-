package model;

public class ToyCreate {
    ToyStore toyStore = new ToyStore();

    public ToyCreate(TypeOfToy type, String name, int weightWin, int amount) {
        Toy toy = new Toy(type, name, weightWin);
        toyStore.AddToyToStore(toy,amount);
    }
}
