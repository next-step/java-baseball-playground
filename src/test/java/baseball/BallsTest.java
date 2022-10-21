package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    Balls answer;

    @BeforeEach
    void setUp() {
        answer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("1스트라이크")
    void one_strike() {
        PlayResult result = answer.play(Arrays.asList(1, 4, 5));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1스트라이크 1볼")
    void one_strike_one_ball() {
        PlayResult result = answer.play(Arrays.asList(1, 3, 4));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("3스트라이크")
    void three_strike() {
        PlayResult result = answer.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1스트라이크 2볼")
    void one_strike_two_ball() {
        PlayResult result = answer.play(Arrays.asList(1, 3, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("낫싱")
    void match_not_at_all() {
        PlayResult result = answer.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @AfterEach
    void tearDown() {
        answer = null;
    }
}
