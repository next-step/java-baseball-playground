package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @Test
    @DisplayName("2 + 3 * 4 / 2 를 입력받으면 10을 출력한다.")
    void prints_out_10() {
        String value = "2 + 3 * 4 / 2";

        StringCalculator stringCalculator = new StringCalculator();
        Integer result = stringCalculator.calculate(value);

        assertThat(result).isEqualTo(10);
    }

}