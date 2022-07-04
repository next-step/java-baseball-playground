package baseball.states;

import baseball.GameBoard;
import baseball.GameController;
import baseball.GameState;

public class ResultState implements GameState {
    private GameBoard gameBoard;
    private GameController gameController;

    public ResultState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printGameResult();
    }

    @Override
    public String readInput() {
        return gameController.getEmptyInputData();
    }

    @Override
    public void evaluatePlayerData(String input) {
        gameController.evaluatePlayerData(input);
    }

    @Override
    public void nextState() {
        gameBoard.setGameState(gameBoard.getInputState());

        if (gameController.isTripleStrike()) {
            gameBoard.setGameState(gameBoard.getDoneState());
        }
    }
}
