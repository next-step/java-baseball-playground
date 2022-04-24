package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallNumberTest {

    @Test
    @DisplayName("사용자가 입력할 수 있는 숫자는 1~9 사이")
    void ball_1_to_9() {
        assertThat(new BallNumber(1).getNo()).isEqualTo(1);
        assertThat(new BallNumber(9).getNo()).isEqualTo(9);
    }

    @Test
    @DisplayName("사용자가 1~9를 벗어날 경우 예외처리")
    void ball_exception() {
        assertThatThrownBy(() -> {
            new BallNumber(10);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("볼 숫자는 1부터 9사이로 입력해야 합니다.");
    }
}
