package study;

import java.util.ArrayList;
import java.util.List;

public class Player {

    List<Integer> integerList = new ArrayList<>();

    public List<Integer> makeNewBalls(List<Integer> newIntegerList) {
        integerList.addAll(newIntegerList);
        return this.integerList;
    }

}
