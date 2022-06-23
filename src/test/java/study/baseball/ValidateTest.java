package study.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidateTest {

    @Test
    void 입력값이_1부터9의_값인지() {
        assertThat(Validation.validNumber(1)).isTrue();
        assertThat(Validation.validNumber(9)).isTrue();
        assertThat(Validation.validNumber(0)).isFalse();
        assertThat(Validation.validNumber(10)).isFalse();
    }
}
