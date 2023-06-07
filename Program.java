import model.toy.ToyCreate;
import model.toy.ToysStore;
import model.toy.TypeOfToy;

public class Program {
    public static void main (String[] args){
        ToyCreate toyCreater;
        ToysStore toystore = new ToysStore();
        toyCreater = new ToyCreate(TypeOfToy.Doll, "Барби", 60, 3);
        //System.out.println(toystore.toString());
    }
}
