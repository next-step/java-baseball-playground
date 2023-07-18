package baseball;

import baseballgame.InputNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class InputNumberTest {
    @Test
    void  야구_숫자_검증() {
        assertThat(InputNumber.validateNumberRange(9)).isTrue();
        assertThat(InputNumber.validateNumberRange(1)).isTrue();
        assertThat(InputNumber.validateNumberRange(0)).isFalse();
        assertThat(InputNumber.validateNumberRange(10)).isFalse();
    }

    @Test
    void 숫자_중복_검증() {

    }
}
