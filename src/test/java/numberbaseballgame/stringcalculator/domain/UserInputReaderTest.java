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

    @Test
    void test_input_is_not_numberic() {
        String input = "j + 1 - 2";
        assertThatThrownBy(() -> {
            userInputReader.convert(input, " ");
        }).hasMessageContaining("숫자가 아닌 값을 입력하셨습니다");
    }
}