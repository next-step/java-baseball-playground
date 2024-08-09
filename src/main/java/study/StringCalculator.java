package study;

import java.util.Scanner;

public class StringCalculator {
    // 사칙연산
    public int add(int a, int b){ return a + b;}
    public int subtract(int a, int b){ return a - b;}
    public int multiply(int a, int b){ return a * b;}
    public int divide(int a, int b){
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }return 0;
    }
    // 분할 메소드
    public String[] split(String str) {
        return str.split(" ");
    }
    public  int toInt(String input) {
        return Integer.parseInt(input);
    }
    public int transform(String[] values) {
        int result = toInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = operator(result, values[i],toInt(values[i+1]));
        }
        return result;
    }
    // 더하기, 곱하기, 나누기, 빼기 함수
    public int operator(int firstValue, String operator, int secondValue) {
        switch (operator) {
            case "+":
                return add(firstValue, secondValue);
            case "-":
                return subtract(firstValue, secondValue);
            case "*":
                return multiply(firstValue, secondValue);
            case "/":
                return divide(firstValue, secondValue);
            default:
                System.out.println("사칙 연산자가 아닙니다.");

        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        StringCalculator T = new StringCalculator();
        T.transform(T.split(value));
    }
}
