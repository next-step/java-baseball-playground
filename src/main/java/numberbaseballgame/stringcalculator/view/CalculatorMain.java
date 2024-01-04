package numberbaseballgame.stringcalculator.view;

import numberbaseballgame.stringcalculator.domain.Calculator;
import numberbaseballgame.stringcalculator.domain.UserInputReader;

import java.util.Scanner;

public class CalculatorMain {
    private static final String SPACE_SEPARATOR = " ";
    public static void main(String[] args) {
        while (true) {
            System.out.print("계산하고 싶은 문자열을 입력해주세요 > ");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();

            UserInputReader userInputReader = new UserInputReader();
            userInputReader.splitBy(inputString, SPACE_SEPARATOR);

            Calculator calculator = new Calculator(userInputReader);
            int result = calculator.performCalculate();

            System.out.println("계산의 결과는 " + result + "입니다");
        }
    }
}
