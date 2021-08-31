package baseball;

import baseball.controller.GameController;
import baseball.controller.RoundController;
import baseball.domain.GameStatus;
import baseball.domain.Generation;
import baseball.domain.RandomNumberGeneration;
import baseball.view.GameView;
import baseball.view.GameConsoleView;
import baseball.view.RoundInputConsoleView;
import baseball.view.RoundInputView;
import baseball.view.RoundOutputConsoleView;
import baseball.view.RoundOutputView;

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
