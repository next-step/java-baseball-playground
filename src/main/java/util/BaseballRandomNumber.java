package util;

import java.util.Random;

public class BaseballRandomNumber implements RandomNumberUtil {
    @Override
    public String[] createRandomNumber() {
        final Random random = new Random();

        int first, second, third;

        first = random.nextInt(9) + 1;

        do {
            second = random.nextInt(9) + 1;
        } while (first == second);

        do {
            third = random.nextInt(9) + 1;
        } while (first == third || third == second );

        return new String[]{String.valueOf(first), String.valueOf(second), String.valueOf(third)};
    }
}
