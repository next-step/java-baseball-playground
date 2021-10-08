package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BallsTest {

    private Balls com;

    @BeforeEach
    void setUp() {
        com = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("하나의 볼에 대한 결과값을 반환하는지 테스트")
    void validateUserBall() {
        List<BallStatus> result = com.validateUserBall(new Ball(1, 2));
        assertThat(result).contains(BallStatus.BALL);

    }

    @Test
    @DisplayName("입력값 전체 테스트")
    void validateUserBalls() {
        Balls user = new Balls(Arrays.asList(1, 3, 4));
        List<Integer> result = Balls.validate(com, user);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(1);
    }
}
