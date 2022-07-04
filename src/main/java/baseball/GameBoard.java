package baseball;

import baseball.states.CloseState;
import baseball.states.DoneState;
import baseball.states.ExitState;
import baseball.states.InitState;
import baseball.states.InputState;
import baseball.states.MenuState;
import baseball.states.ResultState;

public class GameBoard {
    private GameState gameState;
    private InitState initState;
    private InputState inputState;
    private ResultState resultState;
    private DoneState doneState;
    private MenuState menuState;
    private CloseState closeState;
    private ExitState exitState;

    public GameBoard(GameController controller) {
        initGameStates(this, controller);
    }

    private void initGameStates(GameBoard board, GameController controller) {
        initState = new InitState(board, controller);
        inputState = new InputState(board, controller);
        resultState = new ResultState(board, controller);
        doneState = new DoneState(board, controller);
        menuState = new MenuState(board, controller);
        closeState = new CloseState(board, controller);
        exitState = new ExitState(board, controller);
    }

    public void run() {
        setGameState(initState);

        while (gameState.equals(exitState) == false) {
            gameState.viewUpdate();
            String input = gameState.readInput();
            gameState.evaluatePlayerData(input);
            gameState.nextState();
        }
    }

    public void setGameState(GameState state) {
        gameState = state;
    }

    public GameState getInitState() {
        return initState;
    }

    public GameState getInputState() {
        return inputState;
    }

    public GameState getResultState() {
        return resultState;
    }

    public GameState getDoneState() {
        return doneState;
    }

    public GameState getMenuState() {
        return menuState;
    }

    public GameState getCloseState() {
        return closeState;
    }

    public GameState getExitState() {
        return exitState;
    }
}
