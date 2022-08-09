package study.baseballfortdd;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class BallTest {

    Ball computerBall;

    @BeforeEach
    void testReady(){
        computerBall = new Ball(1,2);
    }

    @Test
    @DisplayName("makeNewBallFail")
    void 공_만들기_실패할_경우(){
        assertThrows(IllegalArgumentException.class,
                                () ->  new Ball(0,1));
    }

    @Test
    @DisplayName("BallSuccessTest")
    void 스트라이크일_경우(){
        Ball userBall = new Ball(1,2);
        assertThat(userBall.is(computerBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("BallFailTest")
    void 볼일경우(){
        Ball userBall = new Ball(1,3);
        assertThat(userBall.is(computerBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("BallFailTest")
    void 나띵일경우(){
        Ball userBall = new Ball(3,1);
        assertThat(userBall.is(computerBall)).isEqualTo(BallStatus.NOTHING);
    }
}
