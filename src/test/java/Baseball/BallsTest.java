package Baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_nothing() {
        PlayResult result = computerBalls.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult result = computerBalls.play((Arrays.asList(1, 4, 2)));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strikes() {
        PlayResult result = computerBalls.play((Arrays.asList(1, 2, 3)));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = computerBalls.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = computerBalls.play(new Ball(1, 3));
        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = computerBalls.play(new Ball(1, 4));
        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}
