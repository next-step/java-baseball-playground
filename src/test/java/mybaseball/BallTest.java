package mybaseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    private Ball com;

    @Test
    void Nothing() {
        BallStatus status = com.Play(new Ball(1,3));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
