package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorString {
    private String val = "2 + 3 * 4 / 2";

    private int result = 0;
    @Test
    @DisplayName("왼쪽부터 차례대로 사칙연산")
    void 문자열계산기() {
        String [] arr = val.split(" ");
        result = Integer.parseInt(arr[0]);
        for(int i = 1; i < arr.length; i+=2) {
            계산(arr[i], arr[i+1]);
        }
        assertThat(result).isEqualTo(10);
    }

    void 계산(String a, String b) {
        switch (a) {
            case "+" :
                result = result + Integer.parseInt(b);
                break;
            case "-" :
                result = result - Integer.parseInt(b);
                break;
            case "*" :
                result = result * Integer.parseInt(b);
                break;
            case "/" :
                result = result / Integer.parseInt(b);
        }
    }
}
