package baseball;

import baseballgame.InputNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class InputNumberTest {


    @Test
    void validNumTest() {
        assertThat(InputNumber.validNum("713")).isEqualTo(Arrays.asList(7,1,3));
        assertThat(InputNumber.validNum("711")).isEqualTo(null);
    }

    @Test
    void isDigitTest() {
        assertThat(InputNumber.isSingleDigitNum("d12")).isFalse();
        assertThat(InputNumber.isSingleDigitNum("1d2")).isFalse();
        assertThat(InputNumber.isSingleDigitNum("12d")).isFalse();
        assertThat(InputNumber.isSingleDigitNum("123")).isTrue();
        assertThat(InputNumber.isSingleDigitNum("456")).isTrue();
    }

    @Test
    void isUniqueTest() {
        assertThat(InputNumber.isUnique("112")).isFalse();
        assertThat(InputNumber.isUnique("344")).isFalse();
        assertThat(InputNumber.isUnique("123")).isTrue();
        assertThat(InputNumber.isUnique("131")).isFalse();
    }

    @Test
    void isThreeDigitsTest() {
        assertThat(InputNumber.isThreeDigits("111")).isTrue();
        assertThat(InputNumber.isThreeDigits("1234")).isFalse();
    }
}
