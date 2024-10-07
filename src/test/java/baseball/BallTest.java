package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    private Ball computer;

    @BeforeEach
    void setUp() {
        computer = new Ball(1,4);
    }

    @Test
    void nothing() {
        Ball user = new Ball(2, 5);
        BallStatus status = computer.play(user);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        Ball user = new Ball(2, 4);
        BallStatus status = computer.play(user);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Ball user = new Ball(1, 4);
        BallStatus status = computer.play(user);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
