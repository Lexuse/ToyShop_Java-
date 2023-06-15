package src.model.goods.toy;

import java.util.ArrayList;
import java.util.List;

public enum TypeOfToy {Машина, Кукла, Робот, Животное;

    public static List<String> getType(){
        List<String> result = new ArrayList<>();
        result.add(Машина.name());
        result.add(Кукла.name());
        result.add(Робот.name());
        result.add(Животное.name());
        return result;
    }
}


