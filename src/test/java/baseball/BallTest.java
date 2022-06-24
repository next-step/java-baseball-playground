package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {
    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    void strike() {
        BallUser user = com.play(new Ball(1, 4));
        assertThat(user).isEqualTo(BallUser.STRIKE);
    }

    @Test
    void ball() {
        BallUser user = com.play(new Ball(2, 4));
        assertThat(user).isEqualTo(BallUser.BAll);
    }

    @Test
    void Nothing() {
        BallUser user = com.play(new Ball(2, 5));
        assertThat(user).isEqualTo(BallUser.NOTHING);
    }

}
