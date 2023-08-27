package baseboll.myTrial.second.view;

import baseboll.myTrial.second.NumberProvider;
import baseboll.myTrial.second.checker.GameChecker;

import java.io.IOException;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameChecker gameChecker;
    private final NumberProvider numberProvider;


    public GameController(InputView inputView, OutputView outputView, GameChecker gameChecker, NumberProvider numberProvider) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameChecker = gameChecker;
        this.numberProvider = numberProvider;
    }

    private boolean correct(String input, String answer) {
        return input.equals(answer);
    }

    public void game() throws IOException {
        String answer = numberProvider.makeRandomAnswer();
        System.out.println(answer);
        String input = "";
        while (!correct(input, answer)){
            input = inputView.getInput(); // 인펏부터 받는다
            String checked = gameChecker.check(input, answer);
            outputView.sendOutput(checked);
        }
        if (inputView.wantContinue()) game();
    }
}
