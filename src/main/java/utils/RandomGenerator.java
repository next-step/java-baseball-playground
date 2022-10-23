package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomGenerator {
    private static final int DIGIT_COUNT = 3;

    public List<Integer> createRandomNumbers() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int index = (int) (Math.random() * 10) % list.size();
            numbers.add(list.remove(index));
        }

        return numbers;
    }
}
