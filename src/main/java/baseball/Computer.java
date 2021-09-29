package baseball;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> list;

    public Computer() {
        list = new ArrayList<>();
        SetRandomNumber();
    }

    private void SetRandomNumber() {
        for (int i = 0; i < 3; i++) {
            list.add(DistinctNumber());
        }
    }

    private int DistinctNumber() {
        int RandomNumber = (int) (Math.random() * 9) + 1;
        while (isDistinct(RandomNumber)) {
            RandomNumber = (int) (Math.random() * 9)+ 1;
        }
        return RandomNumber;
    }

    private boolean isDistinct(int RandomNumber) {
        return !getList().isEmpty() && getList().contains(RandomNumber);
    }

    public List<Integer> getList() {
        return list;
    }
}
