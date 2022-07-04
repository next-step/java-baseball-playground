package baseball.states;

import baseball.GameBoard;
import baseball.GameController;
import baseball.GameState;

public class DoneState implements GameState {
    private GameBoard gameBoard;
    private GameController gameController;

    public DoneState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printStageDoneMessage();
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
        gameBoard.setGameState(gameBoard.getMenuState());
    }
}
