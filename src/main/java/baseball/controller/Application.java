package baseball.controller;

import baseball.model.view_interface.InputView;
import baseball.model.view_interface.OutputView;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;


public class Application {
    public static void main(String[] args) {
        OutputView outputView = new ConsoleOutputView();
        InputView inputView = new ConsoleInputView();

        GameController computer = new GameController();
        computer.run(outputView, inputView);
    }
}
