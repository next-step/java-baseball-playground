package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class BaseBallGamePlayTest {

    private BaseBallGame baseBallGame = new BaseBallGame();

    @BeforeEach
    void setUp(BaseBallGame baseBallGame) {
        this.baseBallGame = baseBallGame;
    }

    @Test
    public void testWithBall() {
        // Given
        Balls computer = new Balls(
                Arrays.asList(
                    new Ball(0,1),
                    new Ball(1,8),
                    new Ball(2,9)
                )
        );

        Ball first = new Ball(0, 2);
        Ball second = new Ball(1, 1);
        Ball third = new Ball(2, 8);

        List<Ball> answerList = Arrays.asList(first, second, third);
        Balls answer = new Balls(answerList);

        // When
        ResultDTO result = this.baseBallGame.play(computer, answer);

        // Then
        Assertions.assertEquals(0, result.getStrikeValue());
        Assertions.assertEquals(2, result.getBallValue());
    }

    @Test
    public void testWithStrike() {
        // Given
        Balls computer = new Balls(
                Arrays.asList(
                        new Ball(0,1),
                        new Ball(1,8),
                        new Ball(2,9)
                )
        );

        Ball first = new Ball(0, 1);
        Ball second = new Ball(1, 8);
        Ball third = new Ball(2, 2);

        List<Ball> answerList = Arrays.asList(first, second, third);
        Balls answer = new Balls(answerList);

        // When
        ResultDTO result = this.baseBallGame.play(computer, answer);

        // Then
        Assertions.assertEquals(2, result.getStrikeValue());
        Assertions.assertEquals(0, result.getBallValue());
    }

    @Test
    public void testWithNothing() {
        // Given
        Balls computer = new Balls(
                Arrays.asList(
                        new Ball(0,1),
                        new Ball(1,8),
                        new Ball(2,9)
                )
        );

        Ball first = new Ball(0, 7);
        Ball second = new Ball(1, 2);
        Ball third = new Ball(2, 3);

        List<Ball> answerList = Arrays.asList(first, second, third);
        Balls answer = new Balls(answerList);

        // When
        ResultDTO result = this.baseBallGame.play(computer, answer);

        // Then
        Assertions.assertEquals(0, result.getStrikeValue());
        Assertions.assertEquals(0, result.getBallValue());
    }
}
