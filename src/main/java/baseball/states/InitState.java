package baseball.states;

import baseball.GameBoard;
import baseball.GameController;
import baseball.GameState;

public class InitState implements GameState {
    private GameBoard gameBoard;
    private GameController gameController;

    public InitState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        // Nothing
    }

    @Override
    public String readInput() {
        return gameController.getEmptyInputData();
    }

    @Override
    public void evaluatePlayerData(String input) {
        gameController.evaluatePlayerData(input);
        gameController.prepareDefenderGameDigits();
    }

    @Override
    public void nextState() {
        gameBoard.setGameState(gameBoard.getInputState());
    }
}
