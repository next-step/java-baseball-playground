package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("같은 숫자를 가진 숫자 야구 공일 경우 참, 아닐경우 거짓을 반환한다")
    void hasSameNumber(int ballNumber, int otherNumber, boolean expect) {
        Ball ball = new Ball(ballNumber, 1);
        Ball other = new Ball(otherNumber, 1);

        boolean actual = ball.hasSameNumber(other);

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("같은 위치를 가진 숫자 야구 공일 경우 참, 아닐경우 거짓을 반환한다")
    void hasSameNumberAndPosition(int ballPosition, int otherPosition, boolean expect) {
        Ball ball = new Ball(1, ballPosition);
        Ball other = new Ball(1, otherPosition);

        boolean actual = ball.hasSamePosition(other);

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("1~9를 제외한 숫자를 입력하면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_number(int invalidNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ball(invalidNumber, 1))
                .withMessage("1~9 사이의 숫자를 입력해야 합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    @DisplayName("1~3을 제외한 위치를 입력하면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_position(int invalidPosition) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ball(1, invalidPosition))
                .withMessage("1~3 사이의 위치를 입력해야 합니다");
    }
}
