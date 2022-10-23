package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.ValidationUtils;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ValidationUtilsTest {
    ValidationUtils validationUtils;

    @BeforeEach
    void setUp() {
        validationUtils = new ValidationUtils();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "4,true", "9,true", "0,false"})
    @DisplayName("숫자값은 1 ~ 9의 값이다.")
    void validateNumberRange(int number, boolean expected) {
        assertThat(validationUtils.validateNumber(number)).isEqualTo(expected);
    }

    @Test
    @DisplayName("게임을 하기 위한 숫자의 자리수는 세자리 이다.")
    void validateThreeDigit() {
        assertThat(validationUtils.validateDigit(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validationUtils.validateDigit(Arrays.asList(1, 2))).isFalse();
    }

    @AfterEach
    void tearDown() {
        validationUtils = null;
    }
}
