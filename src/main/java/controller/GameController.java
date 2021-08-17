package controller;

import domain.GameStatus;

import static view.GameView.gameInput;

public class GameController {
    private GameStatus gameStatus;

    private GameController(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public static GameController getInstance() {
        return new GameController(GameStatus.PLAY);
    }

    public void run() {
        while (gameStatus == GameStatus.PLAY) {
            RoundController roundController = RoundController.getInstance();
            roundController.run();
            gameStatus = gameInput();
        }
    }
}
