package baseball;

import java.util.HashSet;
import java.util.Set;

public class Defender {

    int[] gameDigits;
    int strikeCount;
    int ballCount;
    RandomUtil randomUtil;

    public static class MathRandomUtil implements RandomUtil {

        @Override
        public int generateRandomGameDigit(int min, int max) {
            return min + (int)(Math.random() * ((max-min)+1));
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
            int digit = randomUtil.generateRandomGameDigit(1,9);
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

    public void evaluate(String input) {
        Integer[] numbers = convertStringToIntegers(input);
        countStrikes(numbers);
        countBalls(numbers);
    }

    private Integer[] convertStringToIntegers(String input) {
        Integer[] numbers = new Integer[Constant.MAX_DIGITS_LENGTH];

        for (int i = 0; i < input.length(); i++) {
           numbers[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return numbers;
    }

    private void countStrikes(Integer[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            count += compareStrikeColumn(i, input);
        }
        strikeCount = count;
    }

    private int compareStrikeColumn(int index, Integer[] input) {
        if (gameDigits[index] == input[index]) {
            return 1;
        }

        return 0;
    }

    private void countBalls(Integer[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            count += compareBallColumn(i, input);
        }
        ballCount = count;
    }

    private int compareBallColumn(int index, Integer[] input) {
        int nextIndex = (index + 1) % Constant.MAX_DIGITS_LENGTH;
        int nextNextIndex = (nextIndex + 1) % Constant.MAX_DIGITS_LENGTH;

        int count = 0;
        if (gameDigits[index] == input[nextIndex]) {
            count++;
        }
        if (gameDigits[index] == input[nextNextIndex]) {
            count++;
        }

        return count;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public Boolean isTripleStrike() {
        return strikeCount == Constant.MAX_DIGITS_LENGTH;
    }
}
