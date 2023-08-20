package study.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.baseball.PlayerInput;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PlayerInputValidationTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "abc",
            "1", "12",
            "000", "013", "340",
            "-1", "-999"})
    @DisplayName("입력값이_각각_1~9사이의_숫자_3개가_아니면_예외_발생")
    void fail_validate_InputValue (String inputValue) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PlayerInput.validateInputNumber(inputValue);
                }).withMessageMatching("올바른 입력값이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0", "123", "abc", "-1"})
    @DisplayName("게임_옵션_입력은_1,2이_아니면_예외_발생")
    void fail_validate_InputOption (String inputOption) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    PlayerInput.validateInputGameOption(inputOption);
                }).withMessageMatching("올바른 입력값이 아닙니다.");
    }
}
