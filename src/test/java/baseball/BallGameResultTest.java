package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.BallStatus.BALL;
import static baseball.BallStatus.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BallGameResultTest {

    @DisplayName("Is a Empty BallGameResult")
    @Test
    void is_Empty_BallGameResult(){
        BallGameResult ballGameResult = new BallGameResult();
        assertThat(ballGameResult.getCount(BallStatus.STRIKE)).isEqualTo(0);
        assertThat(ballGameResult.getCount(BallStatus.BALL)).isEqualTo(0);
    }

    @DisplayName("Can addCount of BallStatus")
    @Test
    void is_addCount() {
        BallGameResult ballGameResult = new BallGameResult();
        ballGameResult.addCount(STRIKE);
        ballGameResult.addCount(BALL);
        ballGameResult.addCount(BALL);
        assertThat(ballGameResult.getCount(STRIKE)).isEqualTo(1);
        assertThat(ballGameResult.getCount(BALL)).isEqualTo(2);
    }
}