package numberbaseballgame.stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserInputReaderTest {

    UserInputReader userInputReader = new UserInputReader();

    @DisplayName("입력한 문자열을 계산하기에 알맞은 리스트로 반환한다")
    @Test
    void convert_input_test() {
        String input = "1 + 2 - 2";
        assertThat(userInputReader.convert(input, " ")).contains("1", "2", "+", "-");
    }

    @DisplayName("입력한 문자열 중에 숫자가 아닌 다른 값을 입력했을 때의 예외처리 테스트")
    @Test
    void test_input_is_not_numberic() {
        String input = "j + 1 - 2";
        assertThatThrownBy(() -> {
            userInputReader.convert(input, " ");
        }).hasMessageContaining("숫자가 아닌 값을 입력하셨습니다");
    }

    @DisplayName("입력한 문자열 중에 연산 기호가 아닌 문자를 입력했을 때의 예외처리 테스트")
    @Test
    void test_input_is_not_operator() {
        String input = "1 $ 1 @ 2";
        assertThatThrownBy(() -> {
            userInputReader.convert(input, " ");
        }).hasMessageContaining("연산 기호가 아닌 문자를 입력하셨습니다");
    }

    @DisplayName("입력한 문자열 중에 숫자가 10를 넘었을 때 예외처리 테스트")
    @Test
    void test_input_is_not_Integer() {
        String input = "111111111111111111111111 + 19999999999999999999999999999999999999999 - 2";
        assertThatThrownBy(() -> {
            userInputReader.convert(input, " ");
        }).hasMessageContaining("숫자는 10자리까지만 입력이 가능합니다");
    }

}