package baseball;

import java.util.List;
import java.util.Random;

public class RandomNumber {

    public static int makeRandomNumber(List<Integer> balls) {
        Random random = new Random();
        int result = random.nextInt(9) + 1;

        while (!checkRange(result) && !checkOverlap(balls, result)) {
            result = random.nextInt(9) + 1;
        }

        return result;
    }

    public static boolean checkLength(int balls) {
        return String.valueOf(balls).length() == 3;
    }

    public static boolean checkRange(int ball) {
        if (ball > 0 && ball < 10) {
            return true;
        }
        return false;
    }

    public static boolean checkOverlap(List<Integer> balls, int number) {
        if (balls.contains(number)) {
            return false;
        }
        return true;
    }
}
