package baseball.states;

import baseball.Constant;
import baseball.GameBoard;
import baseball.GameController;
import baseball.GameState;

public class MenuState implements GameState {
    private GameBoard gameBoard;
    private GameController gameController;
    private String selectedMenu;

    public MenuState(GameBoard board, GameController controller) {
        gameBoard = board;
        gameController = controller;
    }

    @Override
    public void viewUpdate() {
        gameController.printMenuMessage();
    }

    @Override
    public String readInput() {
        selectedMenu = gameController.readMenuInput();
        return selectedMenu;
    }

    @Override
    public void evaluatePlayerData(String input) {
        gameController.evaluatePlayerData(gameController.getEmptyInputData());
    }

    @Override
    public void nextState() {
        gameBoard.setGameState(gameBoard.getCloseState());

        if (selectedMenu.equals(Constant.MENU_RETRY)) {
            gameBoard.setGameState(gameBoard.getInitState());
        }
    }
}
