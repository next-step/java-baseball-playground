package study.mission01;

public class Calculator {

    private final String operator;

    private String[] values;    // 사용자가 입력한 문자열을 split 한 것

    private int sum;


    public Calculator(String value) {
        operator = "+-*/";
        splitInputValueAndDefaultSettingToSum(value);
        processNextString();
    }

    private void splitInputValueAndDefaultSettingToSum(String value) {
        values = value.split(" ");
        sum = Integer.parseInt(values[0]);
    }

    private void processNextString() {
        String pointer = "";
        // 1. 다음 str 이 연산자일 때, 숫자일 때
        for (int i = 1; i < values.length; i++) {
            if (operator.contains(values[i])) { // 다음 문자가 연산자일 때
                pointer = values[i];
            } else {    // 다음 문자가 숫자일 때
                int number = Integer.parseInt(values[i]);
                operate(sum, pointer, number);
            }
        }
    }

    private void operate(int sum, String pointer, int number) {
        if (pointer.equals("+")) {
            add(sum, number);
        } else if (pointer.equals("*")) {
            multiply(sum, number);
        } else if (pointer.equals("-")) {
            subtract(sum, number);
        } else {
            divide(sum, number);
        }
    }


    private void add(int a, int b) {
        sum = a + b;
    }

    private void subtract(int a, int b) {
        sum = a - b;
    }

    private void multiply(int a, int b) {
        sum = a * b;
    }

    private void divide(int a, int b) {
        sum = a / b;
    }

    public int getResult() {
        return this.sum;
    }
}
