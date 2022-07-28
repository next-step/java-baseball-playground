package string_calculator;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * StringCalculator Version 2.
 * <p>
 * 구현해야될 요구사항
 * 입력한 문자열에 값에 따라 사칙연산을 수행.
 * 띄어쓰기로 구분.
 * <p>
 * 1. 문자열 입력 받을 수 있어야한다.
 * 2. 입력된 문자열을 계산 할 수 있어야한다.
 * -> 숫자와 연산자를 구분 할 수 있어야한다.
 * 3. 예외 처리 해야한다.
 * <p>
 * 책임 할당
 * Operation 이란 Class -> 연산자 계산 처리.
 * String 으로 표현된 숫자를 Integer 형식으로 변환 -> method 이용
 *
 * ENUM 활용.
 */
public class StringCalculatorV2 {

    private String[] inputs;
    private int result = 0;

    public StringCalculatorV2(String input) {
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

    private int calculate(int a, String operation, int b) {
        if (operation.equals(Operation.ADD.oper)) {
            return Operation.add(a, b);
        } else if (operation.equals(Operation.SUB.oper)) {
            return Operation.sub(a, b);
        }else if (operation.equals(Operation.MUL.oper)) {
            return Operation.mul(a, b);
        } else if (operation.equals(Operation.DIV.oper)) {
            return Operation.div(a, b);
        } else {
            throw new InvalidParameterException("연산자가 아닙니다.");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<문자열 계산기>");
        System.out.println("------------");
        System.out.println("----입력값---- : ");
        StringCalculatorV2 stringCalculator = new StringCalculatorV2(scanner.nextLine());
//        System.out.println("계산 결과 : " + result);
    }

}

