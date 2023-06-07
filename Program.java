import model.goods.toy.ToyCreate;
import model.goods.toy.ToysStore;
import model.goods.toy.TypeOfToy;

public class Program {
    public static void main (String[] args){
        ToyCreate toyCreater;
        ToysStore toystore = new ToysStore();
        toyCreater = new ToyCreate(TypeOfToy.Кукла, "Барби", 60, 3);
        //System.out.println(toystore.toString());

    }
}
