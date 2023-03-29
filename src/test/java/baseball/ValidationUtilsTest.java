package baseball;

import baseball.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ValidationUtilsTest {
    @Test
    @DisplayName("숫자야 0~9 사이 숫자 테스트")
    void baseballNumberTest(){
        assertThat(ValidationUtils.validNumTest(9)).isTrue();
        assertThat(ValidationUtils.validNumTest(1)).isTrue();
        assertThat(ValidationUtils.validNumTest(0)).isTrue();
        assertThat(ValidationUtils.validNumTest(-1)).isFalse();
        assertThat(ValidationUtils.validNumTest(10)).isFalse();
    }
}