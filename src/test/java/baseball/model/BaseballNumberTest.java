package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    // TODO: 12/19/23
    // 0, 10 넣기 (O)

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("숫자 야구 넘버는 1 ~ 9 까지의 숫자만 허용한다. 이외의 숫자가 들어오면 IllegalArgumentException 예외 발생")
    void validateNumber(int input) {
        //when
        //then
        assertThatThrownBy(() -> new BaseballNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("저장된 숫자 야구 넘버를 반환한다.")
    void getNumber() {

        //given
        int input = 3;
        BaseballNumber baseballNumber = new BaseballNumber(input);

        //then
        Assertions.assertThat(baseballNumber.getNumber()).isEqualTo(input);
    }
}