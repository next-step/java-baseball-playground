package gameResult;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultVerifyServiceTest {

    private GameResultVerifyService gameResultVerifyService = new GameResultVerifyService();

    @BeforeEach
    public void setUp() {
        gameResultVerifyService = new GameResultVerifyService();
    }

    @Test
    @DisplayName("컴퓨터정답과 입력값 비교 결과 - 3 ball")
    public void testVerifyGameResult_threeBall() {
        int [] answer = {1,2,3};
        int [] input = {2,3,1};

        GameResult gameResult = gameResultVerifyService.verify(answer, input);

        Assertions.assertEquals(3, gameResult.getBall());
        Assertions.assertEquals(0, gameResult.getStrike());

    }

    @Test
    @DisplayName("컴퓨터정답과 입력값 비교 결과 - 3 strike")
    public void testVerifyGameResult_threeStrike() {
        int [] answer = {1,2,3};
        int [] input = {1,2,3};

        GameResult gameResult = gameResultVerifyService.verify(answer, input);

        Assertions.assertEquals(0, gameResult.getBall());
        Assertions.assertEquals(3, gameResult.getStrike());

    }

    @Test
    @DisplayName("컴퓨터정답과 입력값 비교 결과 - 1 strike 2 ball")
    public void testVerifyGameResult_oneStrikeAndTwoBall() {
        int [] answer = {1,2,3};
        int [] input = {1,3,2};

        GameResult gameResult = gameResultVerifyService.verify(answer, input);

        Assertions.assertEquals(2, gameResult.getBall());
        Assertions.assertEquals(1, gameResult.getStrike());

    }

    @Test
    @DisplayName("컴퓨터정답과 입력값 비교 결과 - 2 ball")
    public void testVerifyGameResult_twoBall() {
        int [] answer = {1,2,3};
        int [] input = {4,3,2};

        GameResult gameResult = gameResultVerifyService.verify(answer, input);

        Assertions.assertEquals(2, gameResult.getBall());
        Assertions.assertEquals(0, gameResult.getStrike());

    }

    @Test
    @DisplayName("컴퓨터정답과 입력값 비교 결과 - 2 strike")
    public void testVerifyGameResult_twoStrike() {
        int [] answer = {1,2,3};
        int [] input = {1,9,3};

        GameResult gameResult = gameResultVerifyService.verify(answer, input);

        Assertions.assertEquals(0, gameResult.getBall());
        Assertions.assertEquals(2, gameResult.getStrike());

    }
}
