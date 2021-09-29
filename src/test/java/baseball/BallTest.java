package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    // com = 1,1 2,2 3,3
    private static final Ball com = new Ball(1, 1);


    @Test
    void 야구_공_1개_낫싱_확인() {
        Ball ball = new Ball(1, 4);
        assertThat(ball.play(com)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 야구_공_1개_볼_확인() {
        Ball ball = new Ball(2, 1);
        assertThat(ball.play(com)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 야구_공_1개_스트라이크_확인() {
        Ball ball = new Ball(1, 1);
        assertThat(ball.play(com)).isEqualTo(BallStatus.STRIKE);
    }
}
