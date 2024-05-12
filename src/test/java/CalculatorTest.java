import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @DisplayName("사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있다.")
    @Test
    void calc() {
        // given
        String input = "2 + 3 * 4 / 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Calculator calculator = new Calculator();

        // when
        calculator.calc();
      
        //then
        assertThat(out.toString()).hasToString("10");
    }
    
    @DisplayName("연산식에 사칙연산자가 아닌 연산자가 포함되었다면 연산에 실패한다.")
    @Test
    void calcWithInvalidFormula() {
        // given
        String input = "2 + 3 ^ 4 / 2";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Calculator calculator = new Calculator();
        
        // when then
        assertThatThrownBy(calculator::calc)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 연산식");
    }

}