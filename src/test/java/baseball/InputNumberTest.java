package baseball;

import baseballgame.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class InputNumberTest {


//    @Test
//    @DisplayName("유효성 검사 통과하면 ArrayList 반환")
//    void 유효성_검사_검증() {
//        assertThat(InputNumber.validNum("713")).isEqualTo(Arrays.asList(7,1,3));
//    }

    @Test
    void isDigitTest() {
        assertThat(InputNumber.isDigitNum("d12")).isFalse();
        assertThat(InputNumber.isDigitNum("1d1")).isFalse();
        assertThat(InputNumber.isDigitNum("11d")).isFalse();
        assertThat(InputNumber.isDigitNum("111")).isTrue();
        assertThat(InputNumber.isDigitNum("583")).isTrue();
    }
}
