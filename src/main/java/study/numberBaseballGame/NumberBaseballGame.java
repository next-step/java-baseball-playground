package study.numberBaseballGame;

import java.util.Scanner;

public class NumberBaseballGame {
    private final ThreeNumbers trial = new ThreeNumbers();
    private final ThreeNumbers answer = new ThreeNumbers();
    private final NumberMatcher matcher = new NumberMatcher();
    private boolean continueToken;
    Scanner sc = new Scanner(System.in);
    private Score score;

    private void init() {
        trial.init();
        answer.init();
        answer.generateThreeRandomNumbers();
        continueToken = true;
    }

    public void play() {
        init();
        do {
            continueToken = askAgainUntilWin();
        } while (continueToken);
    }

    private boolean askAgainUntilWin() {
        do {
            insertExpectedThreeNumbers(sc.nextLine());
            printScore();
        } while (!isWinningStatus());

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        if (isGameContinueRequest(sc.nextInt())) return true;
        return false;
    }

    private boolean isGameContinueRequest(int continueInput) {
        if (continueInput != 1 && continueInput != 2) throw new IllegalArgumentException("올바르지 않은 숫자입니다.");
        return continueInput == 1;
    }

    private void printScore() {
        System.out.printf("\n%d볼", score.getBall());
        System.out.printf("%d스트라이크", score.getStrike());
        if (isWinningStatus()) System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    private boolean isWinningStatus() {
        return score.getStrike() == 3;
    }

    public void insertExpectedThreeNumbers(String input) {
        System.out.println("숫자를 입력해주세요 : ");
        trial.insertExpectedThreeNumbers(input);
        score = matcher.calculateScore(trial, answer);
    }
}
