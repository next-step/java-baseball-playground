package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public enum Calculator {
    PLUS("+", (num1, num2)-> num1+num2)
    , MINUS("-", (num1, num2)-> num1-num2)
    , MULTIPLY("*", (num1, num2)-> num1*num2)
    , DIVIDE("/", (num1, num2)-> num1/num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculateFunc;
    Calculator(String operator, BiFunction<Integer, Integer, Integer> calculateFunc){
        this.operator = operator;
        this.calculateFunc = calculateFunc;
    }

    public int calculate(int a, int b){
        return this.calculateFunc.apply(a, b);
    }

    public static Calculator findOperator(String operator){
        return Arrays.stream(values())
                .filter(calculatorOperator -> calculatorOperator.operator.equals(operator))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("올바른 값이 아닙니다"));
    }

    public static void main(String[] args) {
        System.out.println("값을 입력해주숑:");
        Scanner sc = new Scanner(System.in);
        String d = sc.next();
        System.out.println(d);
        sc.next();
    }
}
