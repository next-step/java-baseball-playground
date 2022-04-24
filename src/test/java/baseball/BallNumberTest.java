package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberTest {

    @Test
    @DisplayName("사용자가 입력할 수 있는 숫자는 1~9 사이")
    void ball_1_to_9() {
        assertThat(new BallNumber(1).getNo()).isEqualTo(1);
        assertThat(new BallNumber(9).getNo()).isEqualTo(9);
    }
}
