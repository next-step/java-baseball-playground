package baseball;

import java.util.List;

public class Game {

    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Balls com = numberGenerator.randomNumberGenerator();
        PlayResult result = new PlayResult();
        while (!result.isGameEnd()) {
            List<Integer> user = inputView.userInput();
            result = com.play(user);
            resultView.result(result);
        }

        resultView.isGameEnd();
    }
}
