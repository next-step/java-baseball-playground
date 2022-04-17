package study.numberBaseballGame;

import java.util.Scanner;

public class NumberBaseballGame {
    private final ThreeNumbers trial = new ThreeNumbers();
    private final ThreeNumbers answer = new ThreeNumbers();
    private final NumberMatcher matcher = new NumberMatcher();
    Scanner sc = new Scanner(System.in);
    private Score score;

    public NumberBaseballGame init() {
        trial.init();
        answer.init();
        answer.generateThreeRandomNumbers();
        return this;
    }

    public void play() {
        do {
            System.out.println("숫자를 입력해주세요 : ");
            insertExpectedThreeNumbers(sc.nextLine());
            printScore();
        } while(isWinningStatus());
    }

    private void printScore() {
        System.out.printf("%d볼 %d스트라이크\n", score.getStrike(), score.getBall());
    }

    private boolean isWinningStatus() {
        return score.getStrike() == 3;
    }

    public void insertExpectedThreeNumbers(String input) {
        trial.insertExpectedThreeNumbers(input);
        score = matcher.calculateScore(trial, answer);
    }
}
