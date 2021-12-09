package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    public List<Integer> makeThreeNumbersByCom() {
        List<Integer> comNums = new ArrayList<>();
        while (comNums.size() < 3) {
            int num = new Random().nextInt(9) + 1;
            if (comNums.contains(num)) {
                continue;
            }
            comNums.add(num);
        }
        return comNums;
    }
}