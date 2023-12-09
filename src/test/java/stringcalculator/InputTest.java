package stringcalculator;

import org.junit.Test;

import java.util.Scanner;

public class InputTest {

    @Test
    public void inputData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("테스트 값 입력");
        String testData = Input.inputData(scan);
        System.out.println(testData);
    }
}