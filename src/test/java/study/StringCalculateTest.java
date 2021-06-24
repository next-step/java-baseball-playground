package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculateTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("입력값은 공백 문자열 기준으로 분리되어야 한다.")
    void splitByBlankString(String input) {
        //given
        //when
        String[] values = input.split(" ");

        //then
    }
}
