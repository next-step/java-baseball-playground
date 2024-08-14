package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.BallsNumber.validateNumber;
import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName("user Ball의 유효성 검사- success")
    void validate_success() {
        assertThat(validateNumber(Arrays.asList(1,2,3))).isTrue();
    }
    @Test
    @DisplayName("user Ball의 유효성 검사 - 중복 검사")
    void validate_fail1() {
        assertThat(validateNumber(Arrays.asList(1,2,2))).isFalse();

    }@Test
    @DisplayName("user Ball의 유효성 검사 - 1~9사이 숫자")
    void validate_fail2() {
        assertThat(validateNumber(Arrays.asList(1,2,0))).isFalse();

    }

    // step 3.
    @Test
    @DisplayName("userball 3개와 computerball 3개를 가지고 비교 - strike")
    void play_3strike() {
        Balls computer = new Balls(Arrays.asList(1,2,3));
        Score result = computer.play(Arrays.asList(1,2,3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }
    @Test
    @DisplayName("userball 3개와 computerball 3개를 가지고 비교 - ball")
    void play_1strike_2ball() {
        Balls computer = new Balls(Arrays.asList(1,2,3));
        Score result = computer.play(Arrays.asList(1,3,2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("userball 3개와 computerball 3개를 가지고 비교 - ball")
    void play_nothing() {
        Balls computer = new Balls(Arrays.asList(1,2,3));
        Score result = computer.play(Arrays.asList(4,5,6));
        assertThat(result.getStrike()).isNotEqualTo(1);
        assertThat(result.getBall()).isNotEqualTo(2);
        assertThat(result.isNothing()).isTrue();
    }
    // Step 2.
    @Test
    @DisplayName("userball 1개와 computerball 리스트를 가지고 비교 - strike")
    void strike() {
        Balls computerBall = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computerBall.playBalls(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);

    }
    @Test
    @DisplayName("userball 1개와 computerball 리스트를 가지고 비교 - ball")
    void ball() {
        Balls computerBall = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computerBall.playBalls(new Ball(1, 3))).isEqualTo(BallStatus.BALL);

    }
    @Test
    @DisplayName("userball 1개와 computerball 리스트를 가지고 비교 - nothing")
    void nothing() {
        Balls computerBall = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computerBall.playBalls(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);

    }
}
