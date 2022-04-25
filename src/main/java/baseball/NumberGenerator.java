package baseball;

import java.util.*;

public class NumberGenerator {

    public Balls randomNumberGenerator() {
        List<Integer> result = new ArrayList<>();
        while(result.size() < Balls.BALL_SIZE) {
            int num = new Random().nextInt(9) + 1;
            if (result.contains(num)) {
                continue;
            }
            result.add(num);
        }

        return new Balls(result);
    }
}
