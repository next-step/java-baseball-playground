package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 스트라이크")
    void strike() {
        BallStatus ballStatus = balls.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 볼")
    void ball() {
        BallStatus ballStatus = balls.play(new Ball(3, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 낫싱")
    void nothing() {
        BallStatus ballStatus = balls.play(new Ball(3, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
