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
}
