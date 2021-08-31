package controller;

import domain.GameStatus;
import view.GameView;

public class GameController {

    private final GameView gameView;
    private final RoundController roundController;

    private GameStatus gameStatus;

    public GameController(final RoundController roundController, final GameView gameView, final GameStatus gameStatus) {
        this.roundController = roundController;
        this.gameView = gameView;
        this.gameStatus = gameStatus;
    }

    public static GameController of(final RoundController roundController, final GameView gameView, final GameStatus gameStatus) {
        return new GameController(roundController, gameView, gameStatus);
    }

    public void run() {
        while (gameStatus == GameStatus.PLAY) {
            roundController.run();
            gameStatus = gameView.gameInput();
        }
    }
}
