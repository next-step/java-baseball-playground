package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {
    @Test
    void ball() {
        Ball com = new Ball(1, 4);
        BallUser user = com.play(new Ball(2, 4));
        assertThat(user).isEqualTo(BallUser.BAll);
    }

    @Test
    void Nothing() {
        Ball com = new Ball(1, 4);
        BallUser user = com.play(new Ball(2, 5));
        assertThat(user).isEqualTo(BallUser.NOTHING);
    }

}
