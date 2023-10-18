package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 위치와 숫자 같이 같은 경우 -> strike
 * 위치는 다른데, 숫자 값이 같은 경우 -> ball
 * 숫자 값이 다른 경우 -> nothing
 *
 * com / user
 * 1 4 / 1 4 -> Strike
 * 1 4 / 2 4 -> Ball
 * 1 4 / 2 5 -> Nothing
 */

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        BallStatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }


    @Test
    void nothing() {
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
