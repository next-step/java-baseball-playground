package baseball.util;

import java.util.Random;

public class NumberUtils {
    public static int createRandomNumber(int maxNumber){
        Random random = new Random();
        return random.nextInt(maxNumber) + 1;
    }
}
