package util;

import calculator.Calculator;

public class StringCalculator {

    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a-b;
    }

    public int multiply(int a, int b){
        return a*b;
    }

    public int divide(int a, int b){
        if( b == 0 ){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return a/b;
    }

    public int calculate(String input){
        
        String[] values = input.split(" ");
        int result = Integer.parseInt(values[0]);

        for (int i=1; i<values.length; i=i+2){
            String operator = values[i];
            int number = Integer.parseInt(values[i+1]);
            Calculator calculator = Calculator.findOperator(operator);
            result = calculator.calculate(result, number);
        }

        return result;
    }
}
