package BaseBall;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    void countStrike() {
        Referee referee=new Referee();
        int strike=referee.CountStrike(Arrays.asList(1, 2, 3), Arrays.asList(1, 5, 6));
        Assertions.assertThat(strike).isEqualTo(1);
    }

    @Test
    void countBall() {
        Referee referee =new Referee();
        int ball = referee.CountBall(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2));
        Assertions.assertThat(ball).isEqualTo(3);
    }
}