package study.numberBaseballGame;

public class NumberBaseballGame {
    private ThreeNumbers trial;
    private ThreeNumbers answer;

    public NumberBaseballGame play() {
        answer.generateThreeRandomNumbers();
        return this;
    }

    public NumberBaseballGame insertExpectedThreeNumbers(String input) {
        trial.insertExpectedThreeNumbers(input);
        return this;
    }
}
