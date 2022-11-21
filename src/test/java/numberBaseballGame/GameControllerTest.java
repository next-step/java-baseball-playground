package numberBaseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    GameController gameController;
    List<Integer> computer;
    List<Integer> user;
    Referee referee;

    @BeforeEach
    public void setGameController() {
        computer = Arrays.asList(7, 1, 3);
        user = Arrays.asList(7, 1, 3);
        gameController = new GameController(new Referee(computer, user));
    }

    @Test
    @DisplayName("3스트라이크가 되면 게임 종료")
    public void continueGame() {
        boolean answer = gameController.continueGame();

        assertFalse(answer);
    }
}