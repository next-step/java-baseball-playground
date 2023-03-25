package baseball.model.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputValidatorTest {

    private final InputValidator inputValidator;

    public InputValidatorTest() {
        this.inputValidator = new InputValidatorImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a12", "320"})
    public void validateNaturalNumbersTest(String value) {
        assertThatThrownBy(() -> inputValidator.validateNaturalNumbers(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("각 자리는 자연수로만 이루어져야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "323"})
    public void validateDistinctInputTest(String value) {
        assertThatThrownBy(() -> inputValidator.validateDistinctInput(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 수로 이루어져야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3231", ""})
    public void validateThreeInputTest(String value) {
        assertThatThrownBy(() -> inputValidator.validateThreeInput(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 수로 이루어져야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "0", "a", "", "------"})
    public void validateOneOrTwoTest(String value) {
        assertThatThrownBy(() -> inputValidator.validateOneOrTwo(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 1 또는 2만 가능합니다.");
    }

}
