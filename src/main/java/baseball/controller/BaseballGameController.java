package baseball.controller;

import baseball.domain.*;
import baseball.ui.InputView;
import baseball.ui.ResultView;

import java.util.List;

public class BaseballGameController {
    static NumberGenerator numberGenerator = new NumberGenerator();
    static InputView inputView = new InputView();
    static GameStatus gameStatus;

    public void playGame() {
        do {
            List<GameNumber> computerNumbers = numberGenerator.createGameNumbers(numberGenerator.createRandomNumbers());
            matchNumbers(computerNumbers);

        } while(gameStatus.restartOrQuit(inputView.restartOrQuitInput()));
    }

    private void matchNumbers(List<GameNumber> computerNumbers) {
        Referee referee = new Referee();
        ResultView resultView = new ResultView();
        List<GameNumber> userNumbers;

        do {
            userNumbers = numberGenerator.createUserNumbers(inputView.receiveInput());
            gameStatus = referee.compare(computerNumbers, userNumbers);

        } while (resultView.giveResult(gameStatus));
    }
}
