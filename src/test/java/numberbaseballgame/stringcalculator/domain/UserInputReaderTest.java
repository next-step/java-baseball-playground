package numberbaseballgame.stringcalculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputReaderTest {

    UserInputReader userInputReader = new UserInputReader();

    @DisplayName("입력한 문자열을 계산하기에 알맞은 리스트로 반환한다")
    @Test
    void convert_input_test() {
        String input = "1 + 2 - 2";
        Assertions.assertThat(userInputReader.convert(input, " ")).contains("1", "2", "+", "-");
    }
}