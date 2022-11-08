package baseball;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.NOTHING;
import static baseball.BallStatus.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void strike() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(STRIKE);
    }

    @Test
    void ball() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 3));
        assertThat(ballStatus).isEqualTo(BALL);
    }

    @Test
    void nothing() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 4));
        assertThat(ballStatus).isEqualTo(NOTHING);
    }
}
