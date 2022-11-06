package baseball;

import static baseball.BallStatus.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    @DisplayName("STRIKE 반환")
    public void strike() {
        assertThat(com.play(new Ball(1, 4))).isEqualTo(STRIKE);
    }

    @Test
    @DisplayName("NOTHING 반환")
    public void nothing() {
        assertThat(com.play(new Ball(2, 5))).isEqualTo(NOTHING);
    }

    @Test
    @DisplayName("BALL 반환")
    public void ball() {
        assertThat(com.play(new Ball(2, 4))).isEqualTo(BALL);
    }
}
