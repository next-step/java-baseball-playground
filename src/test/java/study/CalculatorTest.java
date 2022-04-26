package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void split() throws Exception {
        // given
        String str = "1 + 2 * 3";

        // when
        String[] actual = str.split(" ");

        // then
        assertThat(actual).contains("1", "2", "3", "+", "*");
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 2 + 3,6",
            "5 * 10 / 25,2",
            "5,5"
    })
    void calculateSeparateString(String str, int result) throws Exception {
        int actual = calculator.calculateSeparateString(str);
        assertThat(actual).isEqualTo(result);
    }


}
