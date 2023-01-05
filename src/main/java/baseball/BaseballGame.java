package baseball;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballGame {

    // 1. 서로 다른 수로 이루어진 3자리의 수를 생성한다.
    public String createNumber() {
        final Random random = new Random();
        final Set<String> set = new HashSet<>();
        while (set.size() < 3) {
            set.add(String.valueOf(random.nextInt(9) + 1));
        }

        return set.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
