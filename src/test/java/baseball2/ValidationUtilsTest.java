package baseball2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidationUtilsTest {

    @Test
    @DisplayName("숫자 1~9 숫자 검증")
    void 숫자_1_9_검증() {
        Assertions.assertThat(ValidationUtils2.validNo(1)).isTrue();
        Assertions.assertThat(ValidationUtils2.validNo(9)).isTrue();
        Assertions.assertThat(ValidationUtils2.validNo(10)).isFalse();
        Assertions.assertThat(ValidationUtils2.validNo(0)).isFalse();
    }
}
