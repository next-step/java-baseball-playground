import game.BaseballGame;
import number_generator.NumberGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new NumberGenerator();
        BaseballGame baseballGame = new BaseballGame(inputView, outputView, numberGenerator);
        baseballGame.game();
    }
}
