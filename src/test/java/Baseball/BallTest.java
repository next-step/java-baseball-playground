package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 4);
    }

    @Test
    void strike() {
        assertThat(computerBall.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        assertThat(computerBall.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(computerBall.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
    }
}
