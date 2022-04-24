package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("사용자가 컴퓨터가 선택한 3개의 숫자를 모두 맞힐 경우")
    void play_3_strike() {
        PlayResult playResult = balls.play(Arrays.asList(1, 2, 3));
        assertThat(playResult.getStrike()).isEqualTo(3);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertTrue(playResult.isGameEnd());
    }

    @Test
    @DisplayName("3Ball")
    void play_3_ball() {
        PlayResult playResult = balls.play(Arrays.asList(3, 1, 2));
        assertThat(playResult.getStrike()).isEqualTo(0);
        assertThat(playResult.getBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("1 Strike 2 Ball")
    void play_1_strike_2_ball() {
        PlayResult playResult = balls.play(Arrays.asList(1, 3, 2));
        assertThat(playResult.getStrike()).isEqualTo(1);
        assertThat(playResult.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("1 Strike 1 Ball")
    void play_1_strike_1_ball() {
        PlayResult playResult = balls.play(Arrays.asList(1, 4, 2));
        assertThat(playResult.getStrike()).isEqualTo(1);
        assertThat(playResult.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 스트라이크")
    void strike() {
        BallStatus ballStatus = balls.play(new Ball(1, new BallNumber(1)));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 볼")
    void ball() {
        BallStatus ballStatus = balls.play(new Ball(3, new BallNumber(1)));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터가 선택한 3개의 숫자와 사용자가 입력한 하나의 공이 낫싱")
    void nothing() {
        BallStatus ballStatus = balls.play(new Ball(3, new BallNumber(4)));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("사용자가 세자리 숫자를 입력하지 않을 경우 예외처리")
    void user_input_three_number() {
        assertThatThrownBy(() -> {
            balls.play(Arrays.asList(1, 2, 3, 4));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 세자리로 입력해야 합니다.");

        assertThatThrownBy(() -> {
            balls.play(Arrays.asList(1, 2));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자는 세자리로 입력해야 합니다.");
    }
}
