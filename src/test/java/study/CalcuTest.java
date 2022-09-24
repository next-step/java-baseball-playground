package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CalcuTest {
    StringCalculator calculator;

    @BeforeEach
    private void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void testAdd() {
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void testSubtract() {
        assertEquals(3, calculator.substract(100, 97));
    }

    @Test
    public void testMultiply() {
        assertEquals(8, calculator.multiply(2, 4));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(8, 4));
    }

    @Test
    public void testCalculate() {
        assertEquals(6, calculator.makeResult("1 + 2 * 4 / 2"));
    }

    @Test
    @DisplayName("divide에서 assertThatThrownBy를 사용하여 Exception 처리")
    public void testDivideZero() {
        assertThatThrownBy(() -> {
            calculator.divide(3, 0);
        }).isInstanceOf(ArithmeticException.class).hasMessageContaining("by zero");
    }

    @Test
    public void 계산() {
        assertEquals(5, calculator.calculate(1, '+', 4));
    }

    @Test
    public void 에러테스트() {
        assertThatThrownBy(() -> {
            calculator.makeResult(" ");
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("에러 발생");
    }


}

class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public boolean isBlank(String input) {
        if (input.equals(" ") || input == null)
            return true;
        return false;
    }

    public int makeResult(String input) {
        if (isBlank(input))
            throw new RuntimeException("에러 발생");
        return calculateSplitedString(splitBlank(input));
    }

    public String[] splitBlank(String str) {
        return str.split(" ");
    }

    public int toInt(String str) {
        return Integer.parseInt(str);
    }

    public int calculateSplitedString(String[] str) {
        int result = toInt(str[0]);
        for (int i = 0; i < str.length - 2; i += 2) {
            result = calculate(result, str[i + 1].charAt(0), toInt(str[i + 2]));
        }
        return result;
    }

    public int calculate(int firstValue, char operator, int secondValue) {

        if (operator == '+') {
            return add(firstValue, secondValue);
        }
        if (operator == '-') {
            return substract(firstValue, secondValue);
        }
        if (operator == '*') {
            return multiply(firstValue, secondValue);
        }
        if (operator == '/') {
            return divide(firstValue, secondValue);
        }
        throw new RuntimeException();
    }

    public int divide(int firstValue, int secondValue) {
        try {
            return firstValue / secondValue;
        } catch (ArithmeticException e) {
            System.out.println("숫자 0으로 나눌수 없습니다.");
        }
        return firstValue / secondValue;
    }

    public int multiply(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }

    public int substract(int firstValue, int secondValue) {
        return firstValue - secondValue;

    }

    public int add(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }


}