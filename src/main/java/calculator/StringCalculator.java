package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String[] operationType = {"+", "-", "*", "/"};

    public int calculate(String formula) {
        String[] input = formula.split(" ");
        int result = Integer.parseInt(input[0]);
        String operator = null;

        for (int i = 1; i < input.length; i++) {
            //연산자인지 체크
            if (isPermittedOperator(input[i])) {
                operator = input[i];
            }else{
                //계산 수행
                result = partCalculate(operator, result, input[i]);
            }
        }
        return result;
    }

    // 연산자 검증
    private boolean isPermittedOperator(String input) {
        for (String operator : operationType) {
            if (operator.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public int partCalculate(String operator, int result, String input) {
        if(input == null || input.equals("")){
            throw new IllegalArgumentException();
        }

        int secondNum = Integer.parseInt(input);

        switch (operator) {
            case "+":
                return add(result, secondNum);
            case "-":
                return subtract(result, secondNum);
            case "*":
                return multiply(result, secondNum);
            case "/":
                return divide(result, secondNum);
            default:
                throw new IllegalArgumentException();
        }

    }

    public int add(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public int subtract(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    public int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    public int divide(int firstNum, int secondNum) {
        return firstNum / secondNum;
    }

}
