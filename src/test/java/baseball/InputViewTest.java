package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputViewTest {

    static class FakeScanner implements ScannerUtil {

        String buffer;

        public FakeScanner(String input) {
            buffer = input;
        }

        @Override
        public String nextLine() {
            return buffer;
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "12a:false", "1234:false"}, delimiter = ':')
    @DisplayName("3자리 야구 숫자 문자열을 검사한다")
    void verifyTripleGameDigits(String input, Boolean expected) {
        InputView inputView = new InputView();

        Boolean actual = inputView.verifyTripleGameDigits(input);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:true", "112:false"}, delimiter = ':')
    @DisplayName("중복 없는 3자리 야구 숫자열을 검사한다")
    void verifyUniqueTripleGameDigits(String input, Boolean expected) {
        InputView inputView = new InputView();

        Boolean actual = inputView.verifyUniqueTripleGameDigits(input);

        assertThat(actual).isEqualTo(expected);
    }
}
