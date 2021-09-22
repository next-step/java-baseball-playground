package baseball.domain;

import java.util.Random;

public class RandomNumberGeneration implements Generation {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private final Random random;

    public RandomNumberGeneration(final Random random) {
        this.random = random;
    }


    public static Generation from(final Random random) {
        return new RandomNumberGeneration(random);
    }

    @Override
    public int generate() {
        return START_INCLUSIVE + random.nextInt(START_INCLUSIVE + END_INCLUSIVE - START_INCLUSIVE);
    }
}
