package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    public static final int NUMBER_COUNT = 3;

    public Balls(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalStateException("각 숫자가 중복되지 않게 입력하세요.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != NUMBER_COUNT) {
            throw new IllegalStateException("3자리 숫자를 입력하세요.");
        }
    }
}
