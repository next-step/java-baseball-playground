package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 스트라이크")
    void strike() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(ballStatus);
    }
}
