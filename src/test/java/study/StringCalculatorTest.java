package MainStudy;

import MainStudy.StringCalculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;


public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("문자열 분리 테스트")
    void Splited(){
    String SetupValue = "2 + 3 * 4 / 2";
    assertThat(calculator.ValueToArray(SetupValue))
            .containsExactly("2","+","3","*","4","/","2");
    }

    @Test
    @DisplayName("문자열 연산 테스트")
    void CalculatorValues(){
        String SetupValue = "2 + 3 * 4 / 2";
        String[] SetupArrayVal = calculator.ValueToArray(SetupValue);
        assertThat(calculator.CalculatebyValue(SetupArrayVal)).isEqualTo(10);
    }


}

