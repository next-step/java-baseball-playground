package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationUtilTest {

    @Test
    void 숫자_1_9_검증() {
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(0)).isFalse();
        assertThat(ValidationUtils.validNo(10)).isFalse();
    }

    @Test
    void 중복값_존재하는지_검증() {
        assertThat(ValidationUtils.validNoDuplication(123)).isTrue();
        assertThat(ValidationUtils.validNoDuplication(234)).isTrue();
        assertThat(ValidationUtils.validNoDuplication(233)).isFalse();
        assertThat(ValidationUtils.validNoDuplication(777)).isFalse();
    }

    @Test
    void 숫자가_3자리인지() {
        assertThat(ValidationUtils.validLengthThree(123)).isTrue();
        assertThat(ValidationUtils.validLengthThree(456)).isTrue();
        assertThat(ValidationUtils.validLengthThree(444)).isTrue();
        assertThat(ValidationUtils.validLengthThree(1234)).isFalse();
    }
}
