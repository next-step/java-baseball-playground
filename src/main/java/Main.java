import controller.GameController;
import controller.RoundController;
import domain.GameStatus;
import domain.Generation;
import domain.RandomNumberGeneration;
import view.GameView;
import view.GameConsoleView;
import view.RoundInputConsoleView;
import view.RoundInputView;
import view.RoundOutputConsoleView;
import view.RoundOutputView;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundInputView roundInputView = RoundInputConsoleView.from(scanner);
        GameView gameView = GameConsoleView.from(scanner);
        RoundOutputView roundOutputView = RoundOutputConsoleView.getInstance();
        Random random = new Random();
        Generation generation = new RandomNumberGeneration(random);
        RoundController roundController = RoundController.of(roundInputView, roundOutputView, generation);
        GameController gameController = GameController.of(roundController, gameView, GameStatus.PLAY);
        gameController.run();
        scanner.close();
    }
}
