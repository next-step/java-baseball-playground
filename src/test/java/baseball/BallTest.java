package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, new BallNumber(1));
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    void strike() {
        BallStatus ballStatus = com.play(new Ball(1, new BallNumber(1)));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("같은 숫자가 있지만 다른 자리에 있으면 볼")
    void ball() {
        BallStatus ballStatus = com.play(new Ball(3, new BallNumber(1)));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("같은 수가 아니면 낫싱")
    void nothing() {
        BallStatus ballStatus = com.play(new Ball(3, new BallNumber(2)));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
