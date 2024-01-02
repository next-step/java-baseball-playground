package numberbaseballgame.stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserInputReaderTest {

    UserInputReader userInputReader = new UserInputReader();

    @DisplayName("입력받은 문자열을 특정한 문자를 기준으로 나눈다")
    @Test
    void splitBy() {
        assertThat(userInputReader.splitBy("1 + 2 * 3", " "))
                .contains("1", "+", "2", "*", "3");
    }
}