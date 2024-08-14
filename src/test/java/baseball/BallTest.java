package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    // Step 1.
    @Test
    @DisplayName("userball과 computerball 각각 1개씩 비교 - strike")
    void strike() {
        Ball computerBall = new Ball(1, 5);

        assertThat(computerBall.playBall(new Ball(1, 5))).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    @DisplayName("userball과 computerball 각각 1개씩 비교 - ball")
    void ball() {
        Ball computerBall = new Ball(1, 5);
        assertThat(computerBall.playBall(new Ball(2, 5))).isEqualTo(BallStatus.BALL);
    }
    @Test
    @DisplayName("userball과 computerball 각각 1개씩 비교 - nothing")
    void nothing() {
        Ball computerBall = new Ball(1, 5);
        assertThat(computerBall.playBall(new Ball(2, 6))).isEqualTo(BallStatus.NOTHING);
    }
}
