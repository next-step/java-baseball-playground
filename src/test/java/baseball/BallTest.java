package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    //CsvSource or ValueSource needs ParameterizedTest
    @DisplayName("BallNum 1과 9 사이")
    @ParameterizedTest
    @ValueSource(strings ={"1", "5", "9"})
    void isBall(String number) {
        Ball ball = new Ball(number);
        assertThat(ball).isInstanceOf(Ball.class);
        assertThat(Ball.makeBallnum(number)).isEqualTo(number);
    }
}
