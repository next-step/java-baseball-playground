package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    void strike() {
        Ball com = new Ball(1, 1);
        BallStatus ballStatus = com.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("같은 숫자가 있지만 다른 자리에 있으면 볼")
    void ball() {
        Ball com = new Ball(1, 1);
        BallStatus ballStatus = com.play(new Ball(3, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("같은 수가 아니면 낫싱")
    void nothing() {
        Ball com = new Ball(1, 1);
        BallStatus ballStatus = com.play(new Ball(3, 2));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
