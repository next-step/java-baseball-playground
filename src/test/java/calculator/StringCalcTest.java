package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import stringCalc.CalculatorImpl;
import stringCalc.Calculator;

import java.io.*;

public class StringCalcTest {

    @Test
    void name() {
        Calculator calculator = new CalculatorImpl();
        String value = "2 + 3 * 4 / 2";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(value.getBytes());
        System.setIn(in);

        String[] values = value.split(" ");
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                calculator.init(Integer.parseInt(values[i]));
            }
            if ("+-/*".contains(values[i])) {
                calculator.setOperator(values[i]);
            }
            if (!"+-/*".contains(values[i]) && i != 0) {
                calculator.calculate(Integer.parseInt(values[i]));
            }
        }
        calculator.returnValue();
        Assertions.assertThat("answer = 10").isEqualTo(out.toString());
    }
}
