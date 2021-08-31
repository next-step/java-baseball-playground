package baseball.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("1~9 이외의 수를 입력받으면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_number(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> BallNumber.from(number))
                .withMessage("1~9 사이의 숫자를 입력해야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("공의 숫자가 같으면 참 다르면 거짓을 반환한다.")
    void equals(int number, int other, boolean expected) {
        BallNumber ballNumber = BallNumber.from(number);
        BallNumber otherNumber = BallNumber.from(other);

        boolean actual = ballNumber.equals(otherNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
