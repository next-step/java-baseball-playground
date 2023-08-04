package training1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    static Stream<Arguments> numData() {
        return Stream.of(
                Arguments.of("2 * 5 + 1".split(" "), 11),
                Arguments.of("2 + 5 * 1".split(" "), 7),
                Arguments.of("4 / 2 * 6 + 3".split(" "), 15),
                Arguments.of("7 - 1 * 3 + 2".split(" "), 20)
        );
    }


    @ParameterizedTest
    @CsvSource(value = {"4,+,4,8","2,*,4,8","4,-,1,3","4,/,2,2"})
    @DisplayName("계산로직이 정상작동되는지 확인")
    void calculate(int firstNum, String expression, int secondNum, int result){
        StringCalculator s = new StringCalculator();

        assertThat(result).isEqualTo(s.calculate(firstNum,secondNum,expression));
    }

    @ParameterizedTest
    @MethodSource("numData")
    @DisplayName("결과값 호출이 정상적으로 되는지 확인")
    void getResultTest(String[] num, int result){
        StringCalculator s = new StringCalculator();

        assertThat(result).isEqualTo(s.getResult(num));
    }



}
