package baseball.domain;

import java.util.ArrayList;
import java.util.Random;

public class NumberGenerator {
    public ArrayList<Integer> makeThreeNumbersByCom() {
        ArrayList<Integer> comNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = new Random().nextInt(9) + 1;
            comNums.add(num);
        }
        return comNums;
    }
}