package study;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Scanner scanner;

    @BeforeEach
    void setUp() {
        String str = "5 + 9 * 4 / 2";
        InputStream in = new ByteArrayInputStream(str.getBytes());
        scanner = new Scanner(in);
    }


    @Test
    @DisplayName("ScannerUtil 객체를 이용하여 scanner 입력 받아오기")
    void getScannerInput() {
        ScannerUtil util = new ScannerUtil();

        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(input, util.getInput());
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

    /**todo
     * 진행 상황: 테스트 코드로 사칙연산 코드 구현 완료.
     * what to do: calculator 객체로 만들어 놓아야 함.
     */
    @Test
    @DisplayName("사용자가 입력한 문자열 값을 사칙연산하여 답 출력하기")
    void calculate() {
        // value = "2 + 3 * 4 / 2", "5 + 9 * 4 / 2"
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        String operator = "+*/";
        int sum = Integer.parseInt(values[0]);
        System.out.println("sum = " + sum);
        String pointer = "";
        // 제일 첫번째 숫자를 sum 으로 지정하고 연산자 변수에 배열의 다음 순서인 연산자를 저장한다.
        // 배열의 다음 순서가 숫자인 경우에 연산 메소드의 파라미터로 sum, 연산자 변수, 해당 숫자를 같이 넘기고 연산자에 따른 연산을 한 뒤 sum 을 반환하게 한다.

        for (int i = 1; i < values.length; i++) {
            if (operator.contains(values[i])) {
                System.out.println("연산자 = " + values[i]);
                pointer = values[i];
            } else {    // 숫자일 때
                int number = Integer.parseInt(values[i]);
                sum = operate(sum, pointer, number);
            }
        }

        System.out.println("sum = " + sum);

    }

    // sum = 첫 번째 숫자(디폴트), pointer = 연산자, number = 숫자
    private int operate(int sum, String pointer, int number) {
        if (pointer.equals("+")) {
            sum = sum + number;
        } else if (pointer.equals("*")) {
            sum = sum * number;
        } else {
            sum = sum / number;
        }

        return sum;
    }

}