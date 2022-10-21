package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 1);
    }

    @Test
    void strike() {
        assertThat(com.compare(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        assertThat(com.compare(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        assertThat(com.compare(new Ball(2, 1))).isEqualTo(BallStatus.NOTHING);
    }

    @AfterEach
    void tearDown() {
        com = null;
    }
}
