import baseballgame.domain.Ball;
import baseballgame.domain.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 1);
    }

    @Test
    void Strike() {
        BallStatus status = com.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void BALL() {
        //when
        BallStatus status = com.play(new Ball(2, 1));
        //given
        //then
        assertThat(status).isEqualTo(BallStatus.BALL);

    }

    @Test
    void NOTHING() {
        BallStatus status = com.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
