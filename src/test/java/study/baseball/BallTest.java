package study.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BallTest {

    Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 1);
    }

    @Test
    void 스트라이크_테스트() {
        Assertions.assertThat(computerBall.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 볼_테스트() {
        Assertions.assertThat(computerBall.play(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 낫싱_테스트() {
        Assertions.assertThat(computerBall.play(new Ball(2, 2))).isEqualTo(BallStatus.NOTHING);
    }

}
