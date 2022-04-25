package baseball;

import java.util.*;

public class NumberGenerator {

    public List<Integer> randomNumberGenerator() {
        List<Integer> result = new ArrayList<>();
        while(result.size() < 3) {
            int num = new Random().nextInt(9) + 1;
            if (result.contains(num)) {
                continue;
            }
            result.add(num);
        }

        return result;
    }
}
