import model.toy.ToyCreate;
import model.toy.ToyStore;
import model.toy.TypeOfToy;

public class Program {
    public static void main (String[] args){
        ToyCreate toyCreater;
        ToyStore toystore = new ToyStore();
        toyCreater = new ToyCreate(TypeOfToy.Doll, "Барби", 60, 3);
        //System.out.println(toystore.toString());
    }
}
