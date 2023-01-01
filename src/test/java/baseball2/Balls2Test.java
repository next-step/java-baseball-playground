package baseball2;

import static baseball2.BallStatus2.BALL;
import static baseball2.BallStatus2.NOTHING;
import static baseball2.BallStatus2.STRIKE;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Balls2Test {

    private Balls2 com;

    @BeforeEach
    void setUp() {
        com = new Balls2(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_nothing() {
        Balls2 computerBalls = new Balls2(Arrays.asList(1, 2, 3));
        PlayResult2 playResult2 = computerBalls.play(Arrays.asList(4, 5, 6));
        Assertions.assertThat(playResult2.getStrike()).isEqualTo(0);
    }

    @Test
    void play_1ball() {
        Balls2 computerBalls = new Balls2(Arrays.asList(1, 2, 3));
        PlayResult2 playResult2 = computerBalls.play(Arrays.asList(4, 3, 6));
        Assertions.assertThat(playResult2.getBall()).isEqualTo(1);
    }

    @Test
    void play_1strike() {
        Balls2 computerBalls = new Balls2(Arrays.asList(1, 2, 3));
        PlayResult2 playResult2 = computerBalls.play(Arrays.asList(1, 7, 6));
        Assertions.assertThat(playResult2.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("NOTHING 반환")
    void nothing() {
        Assertions.assertThat(com.play(new Ball2(1, 4))).isEqualTo(NOTHING);
    }

    @Test
    @DisplayName("BALL 반환")
    void ball() {
        Assertions.assertThat(com.play(new Ball2(1, 2))).isEqualTo(BALL);
    }

    @Test
    @DisplayName("STRIKE 반환")
    void strike() {
        Assertions.assertThat(com.play(new Ball2(1, 1))).isEqualTo(STRIKE);
    }
}
