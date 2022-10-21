package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
