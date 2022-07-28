package string_calculator;

import java.security.InvalidParameterException;
import java.util.Scanner;


/**
 * StringCalculator Version 1.
 */
public class StringCalculator {

    private String[] inputs;
    private int result = 0;

    public StringCalculator(String input) {
        this.inputs = input.split(" ");
    }

    public void verifyLastString() {
        try {
            Integer.parseInt(inputs[inputs.length - 1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력값 끝자리는 숫자로 끝나야합니다.");
        }
    }

    public int processCalc() throws Exception {
        try {
            result = calculate(Integer.parseInt(inputs[0]), inputs[1], Integer.parseInt(inputs[2]));
            for (int i = 3; i < inputs.length; i += 2) {
                result = calculate(result, inputs[i], Integer.parseInt(inputs[i + 1]));
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자와 연산자가 아닌 문자값이 들어왔거나 , 연산자가 연속으로 사용되었습니다.");
        } catch (InvalidParameterException e) {
            throw new InvalidParameterException("연산자가 아닌 문자값이 들어왔거나 , 숫자가 연속으로 사용되었습니다.");
        } catch (Exception e) {
            throw new Exception("Exception 발생");
        }
        return result;
    }

    private int calculate(int a, String oper, int b) {
        if (oper.equals("+")) {
            return a + b;
        } else if (oper.equals("-")) {
            return a - b;
        } else if (oper.equals("*")) {
            return a * b;
        } else if (oper.equals("/")) {
            return a / b;
        } else {
            throw new InvalidParameterException();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<문자열 계산기>");
        System.out.println("------------");
        System.out.println("----입력값---- : ");
        StringCalculator stringCalculator = new StringCalculator(scanner.nextLine());
        stringCalculator.verifyLastString();
        int result = stringCalculator.processCalc();
        System.out.println("계산 결과 : " + result);
    }

}
