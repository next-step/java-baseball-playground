package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    InputView makeInputViewWithSampleInput(String input) {
        FakeScanner fakeScanner = new FakeScanner(input);
        InputView inputView = new InputView(fakeScanner);

        return inputView;
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234", "a12"})
    @DisplayName("숫자 3자리 규칙에 맞지 않을 때 예외를 발생하는지 검사한다")
    void checkThrowExceptionWhenMismatchingTripleDigitRule(String input) {
        InputView inputView = makeInputViewWithSampleInput(input);

        assertThatThrownBy(() -> {
            String dummy = inputView.readTripleGameDigits();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "111"})
    @DisplayName("중복 숫자 입력을 받았을 때 예외를 발생하는지 검사한다")
    void checkThrowExceptionWhenDuplicatedDigitRule(String input) {
        InputView inputView = makeInputViewWithSampleInput(input);

        assertThatThrownBy(() -> {
            String dummy = inputView.readTripleGameDigits();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
