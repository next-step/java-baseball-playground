package stringCalculator;

public class Operator {
    Calculator cal = new Calculator();
    // 기호별로 계산하기
    public int operate(int firstNum, String operator, int secondNum) {

        if (operator.equals("+")) {
            return cal.add(firstNum, secondNum);
        }
        if (operator.equals("-")) {
            return cal.sub(firstNum, secondNum);
        }
        if (operator.equals("*")) {
            return cal.mul(firstNum, secondNum);
        }
        if (operator.equals("/")) {
            return cal.div(firstNum, secondNum);
        }
        else System.out.println("잘못된 값 입력");
        return 0;
    }
}
