package study.numberBaseballGame;

import static study.numberBaseballGame.InputView.*;
import static study.numberBaseballGame.OutputView.*;

public class NumberBaseballGame {
    private final ThreeNumbers trial = new ThreeNumbers();
    private final ThreeNumbers answer = new ThreeNumbers();
    private final NumberMatcher matcher = new NumberMatcher();
    private boolean continueToken;
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
            askAgainUntilWin();
            askGameContinue();
        } while (continueToken);
    }

    private void askGameContinue() {
        gameContinueMessage();
        int continueGameToken = insertContinueGame();
        if (!isGameContinueRequest(continueGameToken)) {
            continueToken = false;
        }
    }

    private void askAgainUntilWin() {
        do {
            getExpectedThreeNumbers();
            printScore();
        } while (!isWinningStatus());
    }

    private boolean isGameContinueRequest(int continueInput) {
        return continueInput == 1;
    }

    private void printScore() {
        BallMessage(score.getBall());
        StrikeMessage(score.getStrike());
        if (isWinningStatus()) WinGame();
    }

    private boolean isWinningStatus() {
        return score.getStrike() == 3;
    }

    public void getExpectedThreeNumbers() {
        InputNumberMessage();
        String expectedThreeNumbers = insertExpectedThreeNumbers();
        trial.insertExpectedThreeNumbers(expectedThreeNumbers);
        score = matcher.calculateScore(trial, answer);
    }
}
