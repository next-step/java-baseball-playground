package answer.random;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

    private static final int RANDOM_MIN = 1;
    private static final int RANDOM_MAX = 10;

    public static int generateRandomNumber() {
        return ThreadLocalRandom.current().nextInt(RANDOM_MIN, RANDOM_MAX);
    }
}
