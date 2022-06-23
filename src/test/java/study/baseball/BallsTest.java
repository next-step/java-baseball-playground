package study.baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BallsTest {

    private Balls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3스트라이크")
    void allStrike() {
        Score score = computerBalls.play(Arrays.asList(1, 2, 3));
        Assertions.assertThat(score.strike()).isEqualTo(3);
        Assertions.assertThat(score.ball()).isEqualTo(0);
    }

    @Test
    @DisplayName("2볼 1스트라이크")
    void twoBall_oneStrike() {
        Score score = computerBalls.play(Arrays.asList(1, 3, 2));
        Assertions.assertThat(score.strike()).isEqualTo(1);
        Assertions.assertThat(score.ball()).isEqualTo(2);
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void oneBall_oneStrike() {
        Score score = computerBalls.play(Arrays.asList(1, 4, 2));
        Assertions.assertThat(score.strike()).isEqualTo(1);
        Assertions.assertThat(score.ball()).isEqualTo(1);

    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothing() {
        Assertions.assertThat(computerBalls.play(new Ball(2 ,5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("볼 테스트")
    void ball() {
        Assertions.assertThat(computerBalls.play(new Ball(2 ,1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strike() {
        Assertions.assertThat(computerBalls.play(new Ball(2 ,2))).isEqualTo(BallStatus.STRIKE);
    }

}
