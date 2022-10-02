package study.baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    Balls answers;

    @BeforeEach
    void setUP() {
        answers = new Balls(Arrays.asList(1, 4, 5));
    }
    @Test
    void Strike(){
        BallStatus status = answers.play(new Ball(1,1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
    @Test
    void Ball(){
        BallStatus status = answers.play(new Ball(1,4));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        BallStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
