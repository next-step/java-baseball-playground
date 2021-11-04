package baseball.domain;

import baseball.exception.BallNumberSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void duplicate() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Balls("113");
        });

        new Balls("123");
    }

    @Test
    void size() {
        assertThatExceptionOfType(BallNumberSizeException.class).isThrownBy(() -> {
            new Balls("1");
        });

        assertThatExceptionOfType(BallNumberSizeException.class).isThrownBy(() -> {
            new Balls("1234");
        });

        new Balls("123");
    }

    @Test
    void number() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Balls("asd");
        });
    }

    @Test
    void strike() {
        Balls balls = new Balls("123");
        assertThat(balls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls balls = new Balls("123");
        assertThat(balls.play(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls balls = new Balls("123");
        assertThat(balls.play(new Ball(3, 8))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void play() {
        Balls balls = new Balls("123");
        Balls input = new Balls("721");
        GameResult result = balls.play(input);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void end() {
        Balls balls = new Balls("123");
        Balls input = new Balls("123");
        GameResult result = balls.play(input);
        assertThat(result.isEnd()).isTrue();
    }
}
