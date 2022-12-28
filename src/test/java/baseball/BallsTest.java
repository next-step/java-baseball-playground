package baseball;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.NOTHING;
import static baseball.BallStatus.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void play_nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.isGameEnd()).isTrue();
    }


    @Test
    void strike() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 1));
        assertThat(ballStatus).isEqualTo(STRIKE);
    }

    @Test
    void ball() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 3));
        assertThat(ballStatus).isEqualTo(BALL);
    }

    @Test
    void nothing() {
        // given
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        BallStatus ballStatus = balls.play(new Ball(1, 4));
        assertThat(ballStatus).isEqualTo(NOTHING);
    }
}
