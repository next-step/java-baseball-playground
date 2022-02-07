package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalc.Calculator;
import stringCalc.CalculatorImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class BaseBallImplTest {

    BaseBall baseBall;


    @BeforeEach
    void setUp() {
        baseBall = new BaseBallImpl();

    }

    public void startTestGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        String next = scanner.next();
        baseBall.inputValue(next);
    }

    private void baseBallGameForTest(String value) {
        InputStream in = new ByteArrayInputStream(value.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        this.startTestGame();
    }

    @Test
    @DisplayName("resultValue()")
    void resultValue() {
        String value = "123";
        baseBallGameForTest(value);
        baseBall.resultValue();
    }

    @Test
    @DisplayName("inputValue()")
    void inputValue() {
        String value = "345";
        baseBallGameForTest(value);

        String result = "value = 345";
    }

    @Test
    @DisplayName("베이스볼 게임")
    void testBaseball() {
        int value = 111;
        do {
            String string_value = String.valueOf(value);
            baseBallGameForTest(string_value);
            value += 1;
        }while (!baseBall.resultValue());
    }
}