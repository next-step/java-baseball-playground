import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrikeBallTest {

    List<Integer> playerBall = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    List<Integer> comBall = new ArrayList<Integer>(Arrays.asList(9, 2, 3));

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
