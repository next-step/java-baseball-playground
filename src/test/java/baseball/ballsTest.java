package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ballsTest {


    private Balls answer;

    @BeforeEach
    void setUp() {
        answer = new Balls(Arrays.asList(1, 2, 3));

    }

    @Test
    void 세자리수_3_strike() {

        PlayResult result = answer.play(Arrays.asList(1, 2, 3));

        Assertions.assertEquals(result.getStrike(), 3);
        Assertions.assertEquals(result.getBall(), 0);
        Assertions.assertTrue(result.isGameEnd());
    }

    @Test
    void 세자리수_1_strike_1_ball() {

        PlayResult result = answer.play(Arrays.asList(1, 4, 2));

        Assertions.assertEquals(result.getStrike(), 1);
        Assertions.assertEquals(result.getBall(), 1);
    }

    @Test
    void 세자리수_nothing() {

        PlayResult result = answer.play(Arrays.asList(4, 5, 6));

        Assertions.assertEquals(result.getStrike(), 0);
        Assertions.assertEquals(result.getBall(), 0);
    }

    @Test
    void strike() {
        Assertions.assertEquals(answer.play(new Ball(1, 1)), BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Assertions.assertEquals(answer.play(new Ball(1, 3)), BallStatus.BALL);
    }

    @Test
    void nothing() {
        Assertions.assertEquals(answer.play(new Ball(1, 4)), BallStatus.NOTHING);
    }
}
