package study;

import org.junit.jupiter.api.*;
import study.mission01.Calculator;
import study.mission01.ScannerUtil;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    @DisplayName("ScannerUtil 객체를 이용하여 scanner 입력 받아오기")
    @Disabled("ScannerUtil 객체 변경으로 재수정 할 것")
    void getScannerInput() {

        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

    }

    @Test
    @DisplayName("InputStream 객체를 이용하여 scanner 입력 받아오기")
    void getScannerInputUsingInputStream() {
        String str = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(str.getBytes());

        Scanner scanner = new Scanner(in);
        String value = scanner.nextLine();

        assertEquals(str, value);
    }


    @Test
    @DisplayName("Calculator 객체로 문자열 계산기 구현하기")
    void calculateInputValueUsingCalculatorClass() {
        ScannerUtil scannerUtil = new ScannerUtil("2 + 3 / 2 * 9");
        Scanner scanner = scannerUtil.getScanner();

        String value = scanner.nextLine();
        Calculator calculator = new Calculator(value);

        int result = calculator.getResult();

        assertEquals(18, result);

    }
}