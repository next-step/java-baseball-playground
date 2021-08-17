package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    private RandomUtils() {

    }

    public static int generateRandomNumber(final int startInclusive, final int endInclusive) {
        return startInclusive + random.nextInt(endInclusive - startInclusive + 1);
    }
}
