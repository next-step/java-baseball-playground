package baseball.controller;

import baseball.model.exceptions.InputFormatException;
import baseball.model.view_interface.InputView;
import baseball.model.view_interface.OutputView;
import baseball.view.ConsoleInputView;
import baseball.view.ConsoleOutputView;


public class Application {
    private static final String RESTART = "1";

    public static void main(String[] args) {
        OutputView outputView = new ConsoleOutputView();
        InputView inputView = new ConsoleInputView();

        GameController computer = new GameController(outputView, inputView);

        boolean gameStatus = true;

        computer.run();

        while (gameStatus) {
            String decision = inputView.askRestart();
            try {
                validateRestartInput(decision);
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
            if(restart(decision)){
                computer.run();
            }else{
                gameStatus = false;
            }
        }


    }

    private static boolean restart(String decision) {
        if (decision.equals(RESTART)) {
            return true;
        }
        return false;
    }

    private static void validateRestartInput(String input) throws InputFormatException {
        if (input.length() != 1 || Integer.parseInt(input) > 2) {
            throw new InputFormatException("1 혹은 2를 입력해주세요.");
        }
    }

}
