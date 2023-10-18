package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 위치와 숫자 같이 같은 경우 -> strike
 * 위치는 다른데, 숫자 값이 같은 경우 -> ball
 * 숫자 값이 다른 경우 -> nothing
 *
 * com / user
 * 1 4 / 1 4 -> Strike
 * 1 4 / 2 4 -> Ball
 * 1 4 / 2 5 -> Nothing
 */

public class ValidationUtilsTest {
    @Test
    @DisplayName("야구_숫자_1_9_검증")
    void 야구_숫자_1_9_검증() {
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }
}
