package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomListGeneratorImpl implements RandomListGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        final int LIST_SIZE = 3;
        for (int i = 0; i < LIST_SIZE; i++) {
            numbers.add(generateRandomNumber());
        }
        return numbers;
    }

    private static int generateRandomNumber() {
        return new Random().nextInt(9) + 1;
    }
}
