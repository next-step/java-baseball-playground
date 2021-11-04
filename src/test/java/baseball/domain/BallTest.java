package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void strike() {
        Ball ball1 = new Ball(1, 3);
        Ball ball2 = new Ball(1, 3);

        assertThat(ball1.play(ball2)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball ball1 = new Ball(1, 3);
        Ball ball2 = new Ball(2, 3);

        assertThat(ball1.play(ball2)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball ball1 = new Ball(1, 3);
        Ball ball2 = new Ball(2, 4);

        assertThat(ball1.play(ball2)).isEqualTo(BallStatus.NOTHING);
    }
}
