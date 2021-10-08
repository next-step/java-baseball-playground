package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp(){
        com = new Ball(1, 2);
    }
    @Test
    @DisplayName("Strike 테스트")
    void validateStrike() {
        
        BallStatus status = com.validateStatus(new Ball(1, 2));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("Strike 테스트")
    void validateBall() {
        Ball com = new Ball(1, 2);
        BallStatus status = com.validateStatus(new Ball(2, 2));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("Strike 테스트")
    void validateNothing() {
        Ball com = new Ball(1, 2);
        BallStatus status = com.validateStatus(new Ball(2, 3));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}
