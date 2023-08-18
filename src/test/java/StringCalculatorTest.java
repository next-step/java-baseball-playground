import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {
    static StringCalculator sc;
    @BeforeAll
    static void init(){
        sc = new StringCalculator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 / 2", "1 * 2 * 3 * 4"})
    void toStringArray(String s) {
        String[] stringArray = sc.toStringArray(s);

        assertThat(stringArray).contains("*");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3", "2:2", "3:1"}, delimiter = ':')
    void add(int a, int b) {
        int added = sc.add(a, b);

        assertThat(added).isEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource(value = {"15:13", "4:2", "3:1"}, delimiter = ':')
    void subtract(int a, int b) {
        int subtracted = sc.subtract(a, b);

        assertThat(subtracted).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:8", "4:2", "2:4"}, delimiter = ':')
    void multiply(int a, int b) {
        int multiplied = sc.multiply(a, b);

        assertThat(multiplied).isEqualTo(8);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2", "8:4", "16:8"}, delimiter = ':')
    void divideSuccess(int a, int b) {
        int divided = sc.divide(a, b);
        assertThat(divided).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:0", "3:0"}, delimiter = ':')
    void divideFailByDivideBy0(int a, int b){
        assertThatThrownBy(() -> sc.divide(a, b));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5:*", "15:0:-", "30:2:/", "8:7:+"}, delimiter = ':')
    void calculateSuccess(int a, int b, String operator) {
        int calculate = sc.calculate(a, b, operator);
        assertThat(calculate).isEqualTo(15);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5:음", "15:0:오", "30:2:아", "8:7:예", "1:1:?"}, delimiter = ':')
    void calculateFailByOperator(int a, int b, String operator){
        assertThatThrownBy(() -> sc.calculate(a, b, operator));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 * 5", "5 * 3 * 1", "10 + 10 - 5"})
    void calculateString(String s) {
        int calculated = sc.calculateString(s);
        assertThat(calculated).isEqualTo(15);
    }
}