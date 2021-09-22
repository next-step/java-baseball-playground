package baseball.controller;

import baseball.domain.GameStatus;
import baseball.view.GameView;

public class GameController {

    private final GameView gameView;
    private final RoundController roundController;

    public GameController(final RoundController roundController, final GameView gameView) {
        this.roundController = roundController;
        this.gameView = gameView;
    }

    public static GameController of(final RoundController roundController, final GameView gameView) {
        return new GameController(roundController, gameView);
    }

    public void run() {
        GameStatus gameStatus = GameStatus.PLAY;

        while (gameStatus == GameStatus.PLAY) {
            roundController.run();
            gameStatus = gameView.gameInput();
        }
    }
}
