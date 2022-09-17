package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculator {

    public int calculate(int left , int right, String operations) throws IllegalAccessException {
        int result = 0;

        if(operations == "+") {
            result = left + right;
        } else if(operations == "*") {
            result = left * right;
        } else if(operations == "/") {
            result = left / right;
        } else if(right == 0) {
            throw new IllegalAccessException("Division by zero");
        } else {
            throw new IllegalAccessException(operations + "not supported");
        }

        return result;
    }

    @Test
    void calcuateSimpleFormula() throws IllegalAccessException {
        assertThat(calculate(2,3, "+")).isEqualTo(5);
        assertThat(calculate(2,3, "*")).isEqualTo(6);
        assertThat(calculate(4,2, "/")).isEqualTo(2);
        assertThatThrownBy(() -> {
            calculate(3,5, "!");
        }).isInstanceOf(IllegalAccessException.class);

    }

}
