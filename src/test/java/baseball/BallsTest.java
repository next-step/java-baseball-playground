package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest{

    private Balls balls;

    @BeforeEach
    void setUp(){
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @DisplayName("입력된 숫자가 유효하지 않는 낫싱")
    @Test
    void nothing(){
        BaseBallStatus status = balls.play(new Ball(1, 5));
        assertThat(status).isEqualTo(BaseBallStatus.NOTHING);
    }

    @DisplayName("입력된 숫자가 위치만 다른 볼")
    @Test
    void ball(){
        BaseBallStatus status = balls.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BaseBallStatus.BALL);
    }

    @DisplayName("입력된 숫자가 위치와 숫자가 같은 스트라이크")
    @Test
    void strike(){
        BaseBallStatus status = balls.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BaseBallStatus.STRIKE);
    }
}
