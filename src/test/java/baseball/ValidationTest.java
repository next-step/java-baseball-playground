package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {

    @Test
    void 야구_숫자_1_9_확인() {
        assertThat(Validation.confirmNumber(1)).isEqualTo(true);
        assertThat(Validation.confirmNumber(0)).isEqualTo(false);
        assertThat(Validation.confirmNumber(9)).isEqualTo(true);
        assertThat(Validation.confirmNumber(10)).isEqualTo(false);
    }

    @Test
    void 야구_중복_숫자_확인() {
        assertThat(Validation.confirmDuplication(Arrays.asList(1, 2, 2))).isEqualTo(true);
        assertThat(Validation.confirmDuplication(Arrays.asList(2, 3, 2))).isEqualTo(true);
        assertThat(Validation.confirmDuplication(Arrays.asList(3, 3, 2))).isEqualTo(true);
        assertThat(Validation.confirmDuplication(Arrays.asList(1, 2, 3))).isEqualTo(false);
    }
}
