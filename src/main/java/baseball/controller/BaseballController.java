package baseball.controller;

import baseball.model.BaseballNumbers;
import baseball.model.RandomNumbers;
import baseball.model.Referee;
import baseball.model.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseballController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    RandomNumbers randomNumbers = new RandomNumbers();
    UserNumbers userNumbers = new UserNumbers();

    public void start() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        outputView.printStartGameMessage();
        while (number != 2) {
            BaseballNumbers baseballNumbers = new BaseballNumbers(randomNumbers.create());
            inputView.printInputNumbersMessage();
            Referee referee = new Referee(baseballNumbers, userNumbers.inputUserNumbers());
            outputView.printRefereeMessage(referee.getBall(), referee.getStrike());
            if (referee.getStrike() == 3) {
                inputView.printInputGameRestartMessage(referee.getStrike());
                number = scanner.nextInt();
                randomNumbers.deleteComputerNumbers();
            }
            userNumbers.deleteUserInputNumbers();
            referee.resetBallStrikeCount();
        }
    }
}