package baseball;

import java.util.Random;

public class BaseBallGame {

    public String createNumber(int numberLength) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        while (numberLength > 0) {
            stringBuilder.append(random.nextInt(10));
            numberLength--;
        }
        return String.valueOf(stringBuilder);
    }

    public String gameResults(String answerNumber, String numbers) {

        StringBuilder sb = new StringBuilder();
        int ball = checkForBall(answerNumber, numbers);
        if (ball > 0) sb.append(combinationOfResults(ball, "볼"));

        int strike = checkForStrike(answerNumber, numbers);
        if (strike > 0) sb.append(combinationOfResults(strike, "스트라이크"));

        if (ball == 0 && strike == 0) sb.append("낫싱");

        return sb.toString();
    }

    public int checkForStrike(String correct, String numbers) {
        int strike = 0;
        for (int i = 0; i < correct.length(); i++) {
            if (correct.charAt(i) == numbers.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int checkForBall(String correct, String numbers) {
        int ball = 0;
        for (int i = 0; i < numbers.length(); i++) {
            boolean isContains = correct.contains(
                String.valueOf(numbers.charAt(i))
            );
            if (correct.charAt(i) != numbers.charAt(i) && isContains) {
                ball++;
            }
        }
        return ball;
    }

    public String combinationOfResults(int count, String text) {
        return count + text;
    }
}