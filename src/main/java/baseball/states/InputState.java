package baseball.states;

import baseball.GameBoard;
import baseball.GameController;
import baseball.GameState;

public class InputState implements GameState {
    private GameBoard gameBoard;
    private GameController gameController;

    public InputState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printInputTripleGameDigitsMessage();
    }

    @Override
    public String readInput() {
        return gameController.readTripleGameDigits();
    }

    @Override
    public void evaluatePlayerData(String input) {
        gameController.evaluatePlayerData(input);
    }

    @Override
    public void nextState() {
        gameBoard.setGameState(gameBoard.getResultState());
    }
}
