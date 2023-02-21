package racing;

import racing.console.ConsoleInputView;
import racing.console.ConsoleOutputView;
import racing.core.Game;
import racing.core.InputView;
import racing.core.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        Game game = new Game(inputView, outputView);
        game.play();
    }
}
