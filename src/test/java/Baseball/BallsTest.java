package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    Balls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {
        assertThat(computerBalls.play(new Ball(1,4))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(computerBalls.play(new Ball(1,3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(computerBalls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void playNothing() {
        PlayResult playResult = computerBalls.play(Arrays.asList(4, 5, 6));
        assertThat(playResult.getStrikeCount()).isEqualTo(0);
        assertThat(playResult.getBallCount()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult playResult = computerBalls.play(Arrays.asList(1, 3, 4));
        assertThat(playResult.getStrikeCount()).isEqualTo(1);
        assertThat(playResult.getBallCount()).isEqualTo(1);
    }

    @Test
    void play_3strikes() {
        PlayResult playResult = computerBalls.play(Arrays.asList(1, 2, 3));
        assertThat(playResult.getStrikeCount()).isEqualTo(3);
        assertThat(playResult.getBallCount()).isEqualTo(0);
        assertThat(playResult.isGameEnd()).isTrue();
    }
}
