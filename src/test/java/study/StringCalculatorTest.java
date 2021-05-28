package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void 두수의덧셈() {
        String[] inputs = "2 + 5".split(" ");

        int num1 = Integer.parseInt(inputs[0]);
        int num2 = Integer.parseInt(inputs[2]);
        String calculator = inputs[1];

        int result = getResult(num1, num2, calculator);

        assertThat(inputs.length).isEqualTo(3);
        assertThat(result).isEqualTo(7);
    }

    @Test
    void 세수의덧셈() {
        String[] inputs = "2 + 5 + 3".split(" ");

        int result = 0;
        int loopCount = (inputs.length/2+1);

        for (int i = 0; i<loopCount; i++) {
            int num = Integer.parseInt(inputs[(i*2)]);
            String calculator = getCalculator(inputs, i);
            result = getResult(result, num, calculator);
        }

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 세수의덧셈과뺄셈() {
        String[] inputs = "2 + 5 - 3".split(" ");

        int result = 0;
        int loopCount = (inputs.length/2+1);

        for (int i = 0; i<loopCount; i++) {
            int num = Integer.parseInt(inputs[(i*2)]);
            String calculator = getCalculator(inputs, i);
            result = getResult(result, num, calculator);
        }

        assertThat(result).isEqualTo(4);
    }

    @Test
    void 네수의복합연산() {
        String[] inputs = "2 + 3 * 4 / 2".split(" ");

        int result = 0;
        int loopCount = (inputs.length/2+1);

        for (int i = 0; i<loopCount; i++) {
            int num = Integer.parseInt(inputs[(i*2)]);
            String calculator = getCalculator(inputs, i);
            result = getResult(result, num, calculator);
        }

        assertThat(result).isEqualTo(10);
    }

    private String getCalculator(String[] inputs, int i) {
        String calculator = "+";
        if (i >0) {
            calculator = inputs[(i * 2 - 1)];
        }
        return calculator;
    }

    private int getResult(int num1, int num2, String calculator) {
        int result = 0;
        switch (calculator) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/": result = num1 / num2; break;
        }
        return result;
    }

}
