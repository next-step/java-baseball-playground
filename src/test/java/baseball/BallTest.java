package baseball;

import org.assertj.core.internal.IterableElementComparisonStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallStatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void nothing() {
        BallStatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
