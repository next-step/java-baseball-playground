package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    @DisplayName("야구 숫자 1~9까지 유효한지 검증")
    void 숫자_1_9_까지_유효성검증() {
        Assertions.assertThat(ValidationUtils.validNumFromOneToNine(1)).isTrue();
        Assertions.assertThat(ValidationUtils.validNumFromOneToNine(9)).isTrue();
        Assertions.assertThat(ValidationUtils.validNumFromOneToNine(0)).isFalse();
        Assertions.assertThat(ValidationUtils.validNumFromOneToNine(10)).isFalse();
    }

}
