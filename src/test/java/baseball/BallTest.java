package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    @Test
    @DisplayName("스트라이크 결과를 얻어내는지 확인합니다.")
    void getResult_isStrike_true() {
        Ball answer = new Ball(1,4);
        Ball input = new Ball(1,4);
        assertThat(answer.getResult(input)).isEqualTo(PitchStatus.STRIKE);
    }
    @Test
    @DisplayName("볼 결과를 얻어내는지 확인합니다.")
    void ball() {
        Ball answer = new Ball(1,4);
        Ball input = new Ball(2,4);
        assertThat(answer.getResult(input)).isEqualTo(PitchStatus.BALL);
    }
    @Test
    @DisplayName("낫싱 결과를 얻어내는지 확인합니다.")
    void nothing() {
        Ball answer = new Ball(1,4);
        Ball input = new Ball(2,3);
        assertThat(answer.getResult(input)).isEqualTo(PitchStatus.NOTHING);
    }
}