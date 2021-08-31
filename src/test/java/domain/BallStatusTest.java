package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BallStatusTest {

    @ParameterizedTest
    @CsvSource(value = {"STRIKE,true", "BALL,false","NOTHING,false"})
    @DisplayName("숫자 야구의 상태가 스트라이크 여부를 확인한다")
    void isStrike(BallStatus ballStatus, boolean expected) {
        assertThat(ballStatus.isStrike()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"STRIKE,false", "BALL,true", "NOTHING,false"})
    @DisplayName("숫자 야구의 상태가 볼 여부를 확인한다")
    void isBall(BallStatus ballStatus, boolean expected) {
        assertThat(ballStatus.isBall()).isEqualTo(expected);
    }

}
