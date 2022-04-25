package baseball;

import java.util.List;

public class Game {

    private static NumberGenerator numberGenerator;
    private static InputView inputView;
    private static ResultView resultView;
    public static void main(String[] args) {

        numberGenerator = new NumberGenerator();
        inputView = new InputView();
        resultView = new ResultView();

        boolean inGame = true;
        while(inGame) {
            inGame = startGame();
        }
    }

    private static boolean startGame() {
        Balls com = numberGenerator.randomNumberGenerator();
        PlayResult result = new PlayResult();
        while (!result.isGameEnd()) {
            List<Integer> user = inputView.userInput();
            result = com.play(user);
            resultView.result(result);
        }

        resultView.gameEndMessage();

        return restartGame();
    }

    private static boolean restartGame() {
        if (inputView.isGameEnd()) {
            return false;
        }

        return true;
    }
}
