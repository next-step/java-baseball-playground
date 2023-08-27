package baseboll.myTrial.second;

import baseboll.myTrial.second.checker.GameChecker;
import baseboll.myTrial.second.view.GameController;
import baseboll.myTrial.second.view.InputView;
import baseboll.myTrial.second.view.OutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameChecker gameChecker = new GameChecker();
        NumberProvider numberProvider = new NumberProvider();
        GameController gameController = new GameController(inputView, outputView, gameChecker, numberProvider);
        gameController.game();
    }
}
