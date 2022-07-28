package java_baseball;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Baseball {
    public static final int NUMBER_OF_DIGIT = 3;
    public static ArrayList<Integer> answers = new ArrayList<>();
    public static ArrayList<Integer> numbers = new ArrayList<>();

    private Result result;

    public void createRandomNumber() {
        Random random = new Random();
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            int num = random.nextInt(10);
            if (answers.contains(num)) {
                i--;
                continue;
            }
            answers.add(num);
        }
    }

    public void makeResult() {
        int strike = getStrike();
        int ball = compare() - strike;
        if (strike == 3) {
            System.out.println(Result.COMPLETE.toString());
            return;
        }
        print(strike,ball);
    }

    private void print(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.print(Result.NOTHING.toString());
        } else if (!(strike == 0 && ball == 0)) {
            System.out.println(strike + " 스트라이크, " + ball + " 볼");
        }
    }

    public int compare() {
        int result = 0;
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            if (answers.contains(numbers.get(i))) {
                result++;
            }
        }
        return result;
    }

    public int getStrike() {
        int result = 0;
        for (int i = 0; i < NUMBER_OF_DIGIT; i++) {
            if (answers.get(i) == numbers.get(i)) {
                result++;
            }
        }
        return result;
    }

    public int getBall() {
        int result = compare() - getStrike();
        return result;
    }

    /**
     * 개선해야할 부분.
     *
     * @param input
     */
    public void createUserInput(String input) {
        try {
            for (char c : input.toCharArray()) {
                int num = Integer.parseInt(String.valueOf(c));
                numbers.add(num);
            }
        } catch (NumberFormatException e) {
            System.out.println("입력값은 3자리 숫자여야합니다.");
        } catch (Exception e) {
            System.out.println("예상치 못한 오류 발생!");
        }
    }
}
