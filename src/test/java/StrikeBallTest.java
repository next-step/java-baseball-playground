import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrikeBallTest {

    int playerBall = 123;
    int comBall = 456;

    Baseball baseball = new Baseball(playerBall, comBall);

    @Test
    @DisplayName("whether there is number in comball")
    void isThereNum() {
        assertThat(baseball.isThereNum()).isTrue();
    }

    @Test
    @DisplayName("count ball test")
    void countBall() {
        assertThat(baseball.ballCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("count strike test")
    void countStrike() {
        assertThat(baseball.strikeCount()).isEqualTo(2);
    }
}
