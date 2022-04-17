package study;

public class StringCalculator {
    private String input;
    private int result;

    public StringCalculator inputString(String s) {
        input = s;
        return this;
    }

    public int calculate() {
        String[] stringList = splitInput();
        initResult(stringList[0]);
        for (int i = 1; i < stringList.length; i+=2) {
            doOperation(stringList[i], stringList[i+1]);
        }
        return result;
    }

    private void doOperation(String op, String value) {
        int intValue = Integer.parseInt(value);
        switch (op) {
            case "+":
                result += intValue;
                break;
            case "-":
                result -= intValue;
                break;
            case "*":
                result *= intValue;
                break;
            case "/":
                if (intValue == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                result /= intValue;
                break;
            default:
                throw new IllegalArgumentException("지원하지 않는 문자가 들어왔습니다.");
        }
    }

    private void initResult(String initValue) {
        result = Integer.parseInt(initValue);
    }

    private String[] splitInput() {
        return input.split(" ");
    }

    public void init() {
        result = 0;
    }
}
