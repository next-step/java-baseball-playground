package baseball;

import java.util.HashSet;
import java.util.Set;

public class Defender {

    int[] gameDigits;
    RandomUtil randomUtil;

    public interface RandomUtil {
        int generateRandomGameDigit();
    }

    public static class MathRandomUtil implements RandomUtil {

        @Override
        public int generateRandomGameDigit() {
            return (int) (Math.random() * 10 % 10);
        }
    }

    public Defender(RandomUtil customRandom) {
        gameDigits = new int[]{0,0,0};
        randomUtil = customRandom;
    }

    public Defender() {
        gameDigits = new int[]{0,0,0};
        randomUtil = new MathRandomUtil();
    }

    public void prepareGameDigits() {
        Set<Integer> randomSet = new HashSet<>();

        while (randomSet.size() < Constant.MAX_DIGITS_LENGTH) {
            int digit = randomUtil.generateRandomGameDigit();
            randomSet.add(digit);
        }

        int index = 0;
        for (int pickedDigit : randomSet) {
            gameDigits[index] = pickedDigit;
            index++;
        }
    }

    public int getGameDigitsAt(int index) {
        return gameDigits[index];
    }
}
