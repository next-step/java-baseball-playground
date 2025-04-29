import org.junit.jupiter.api.Test;
import tdd.Calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void 덧셈_연산() {
        String str = "2 + 3";

        int result = Calculator.calculator(str);
        assertEquals(result, 5);

    }

    @Test
    void 뺼셈_연산() {
        String str = "5 - 2";

        int result = Calculator.calculator(str);
        assertEquals(result, 3);
    }

    @Test
    void 곱셈_연산() {
        String str = "5 * 2";

        int result = Calculator.calculator(str);
        assertEquals(result, 10);
    }

    @Test
    void 나눗셈_연산() {
        String str = "20 / 2";

        int result = Calculator.calculator(str);
        assertEquals(result, 10);
    }

    @Test
    void 실패_케이스() {

        String str1 = "";
        assertThatThrownBy(() -> Calculator.calculator(str1))
                .isInstanceOf(IllegalArgumentException.class);

        String str2 = "20 / /";
        assertThatThrownBy(() -> Calculator.calculator(str2))
                .isInstanceOf(NumberFormatException.class);
    }
}