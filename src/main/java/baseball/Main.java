package baseball;

import baseball.domain.Balls;
import baseball.domain.GameResult;
import baseball.service.RandomGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int gameStart = 1;

        while (gameStart == 1) {
            Balls randomBalls = RandomGenerator.getRandomBalls();

            while (true) {
                String inputNumber = InputView.inputNumber();

                GameResult result = randomBalls.play(new Balls(inputNumber));
                if (result.isEnd()) {
                    System.out.println(ResultView.endMessage());
                    System.out.println(ResultView.restartMessage());
                    String restartInput = InputView.input();

                    if (!restartInput.equals("1")) {
                        gameStart = 2;
                    }
                    break;
                }

                System.out.println(ResultView.result(result));
            }
        }
    }
}
