package src.model.goods.toy;

import java.util.ArrayList;
import java.util.List;

public enum TypeOfToy {
    МАШИНА, КУКЛА, РОБОТ, ЖИВОТНОЕ;

    public static List<String> getType(){
        List<String> result = new ArrayList<>();
        result.add(МАШИНА.name());
        result.add(КУКЛА.name());
        result.add(РОБОТ.name());
        result.add(ЖИВОТНОЕ.name());
        return result;
    }
}


