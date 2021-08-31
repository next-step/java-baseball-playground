import controller.GameController;
import controller.RoundController;
import domain.GameStatus;
import view.GameView;
import view.GameConsoleView;
import view.RoundInputConsoleView;
import view.RoundInputView;
import view.RoundOutputConsoleView;
import view.RoundOutputView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final RoundInputView roundInputView = RoundInputConsoleView.from(scanner);
        final GameView gameView = GameConsoleView.from(scanner);
        final RoundOutputView roundOutputView = RoundOutputConsoleView.getInstance();
        final RoundController roundController = RoundController.of(roundInputView, roundOutputView);
        final GameController gameController = GameController.of(roundController, gameView, GameStatus.PLAY);
        gameController.run();
        scanner.close();
    }
}
