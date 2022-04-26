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
            "5,5",
            "0 / 1,0"
    })
    void calculateSeparateString(String str, int result) throws Exception {
        int actual = calculator.calculateSeparateString(str);
        assertThat(actual).isEqualTo(result);
    }

    @DisplayName("짝수가 숫자가 아니면 IllegalArgumentException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "0 + +", "10 + 5 - ="})
    void even_only_number(String str) throws Exception {
        assertThatThrownBy(() -> calculator.calculateSeparateString(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("짝수에는 숫자만 존재해야 합니다.");
    }

    @DisplayName("홀수가 사칙연산자가 아니면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0 1 2", "1 + 2 3 3"})
    void odd_only_separate(String str) throws Exception {
        assertThatThrownBy(() -> calculator.calculateSeparateString(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 안는 연산자 입니다.");
    }

    @DisplayName("배열 길이가 홀수가 아니거나 사이즈가 0이라면 ArrayIndexOutOfBoundsException예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1 2", "1 + 2 3", " "})
    void split_length_odd(String str) throws Exception {
        assertThatThrownBy(() -> calculator.calculateSeparateString(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백을 기준으로 홀수여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 / 0", "0 + 5 / 0"})
    void zero_by_division(String str) throws Exception {
        assertThatThrownBy(() -> calculator.calculateSeparateString(str))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("0으로는 나눌수 없습니다.");
    }


}
