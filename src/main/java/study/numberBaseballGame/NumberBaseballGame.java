package study.numberBaseballGame;

public class NumberBaseballGame {
    private final ThreeNumbers trial = new ThreeNumbers();
    private final ThreeNumbers answer = new ThreeNumbers();
    private final NumberMatcher matcher = new NumberMatcher();
    private Score score;

    public NumberBaseballGame play() {
        trial.init();
        answer.init();
        answer.generateThreeRandomNumbers();
        return this;
    }

    public NumberBaseballGame insertExpectedThreeNumbers(String input) {
        trial.insertExpectedThreeNumbers(input);
        score = matcher.calculateScore(trial, answer);
        return this;
    }
}
