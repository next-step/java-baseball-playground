package baseball.service;

import baseball.domain.Balls;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {

    private RandomGenerator() {
    }

    public static Balls getRandomBalls() {
        Set<Integer> numberSet = getRandomNumberSet();

        String numbers = "";
        for (int num : numberSet) {
            numbers += num;
        }

        return new Balls(numbers);
    }

    private static Set<Integer> getRandomNumberSet() {
        Set<Integer> numberSet = new HashSet<>();
        Random random = new Random();

        while (numberSet.size() < 3) {
            int num = random.nextInt(8) + 1;
            numberSet.add(num);
        }

        return numberSet;
    }
}
