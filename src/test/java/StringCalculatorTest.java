import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void splitTest() {
        String testData = "2 + 3 * 4 / 2";
        String[] values = stringCalculator.split(testData);

        assertThat(values.length).isEqualTo(7);
        assertThat(values).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    void calculatorTest() {
        String testData = "2 + 3 * 4 / 2";
        int result = stringCalculator.calculator(testData.split(" "));

        assertThat(result).isEqualTo(10);
    }

    @Test
    void fullTest() {
        String data = "4 + 10 / 2 * 5 + 10"; // 왼쪽에서 부터 순서대로 계산 = 45

        int result = stringCalculator.calculator(stringCalculator.split(data));

        assertThat(result).isEqualTo(45);
    }
}