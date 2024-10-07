package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    private Balls answer;

    @BeforeEach
    void setUp() {
        answer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play() {
        PlayResult result = answer.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrikes()).isEqualTo(0);
        assertThat(result.getBalls()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        PlayResult result = answer.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrikes()).isEqualTo(1);
        assertThat(result.getBalls()).isEqualTo(1);
    }

    @Test
    void nothing() {
        BallStatus status = answer.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        BallStatus status = answer.play(new Ball(1, 3));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        BallStatus status = answer.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
