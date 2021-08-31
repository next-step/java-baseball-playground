package baseball.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    @DisplayName("1~3 사이의 위치값이 아니면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_position(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.from(value))
                .withMessage("1~3 사이의 위치를 입력해야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("위치가 같으면 참, 다르면 거짓을 반환한다")
    void equals(int value, int otherPosition, boolean expected) {
        Position position = Position.from(value);
        Position other = Position.from(otherPosition);

        boolean actual = position.equals(other);

        assertThat(actual).isEqualTo(expected);
    }
}
