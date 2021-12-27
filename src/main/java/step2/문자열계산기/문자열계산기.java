package step2.문자열계산기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열계산기 {

    private String[] operationType = {"+", "-", "*", "/"};

    public int calculate(String formula){
        String[] input = formula.split(" ");
        int result = Integer.parseInt(input[0]);
        String operator = null;

        for(int i=1; i<input.length; i++){
            if(isPermittedOperator(input[i])){
                operator = input[i];
            }else{
                result = parCalculate(operator, result, input[i]);
            }
        }
        return result;
    }

    public int parCalculate(String operator, int result, String input){
        if(input == null || input.equals("")) throw new IllegalArgumentException();

        switch(operator){
            case "+":
                return plus(result, input);
            case "-":
                return minus(result, input);
            case "*":
                return multiply(result, input);
            case "/":
                return division(result, input);
            default:
                throw new IllegalArgumentException();
        }
    }


    private boolean isPermittedOperator(String input){
        for(String operator : operationType){
            if(input.equals(operator)) return true;
        }
        return false;
    }

    public int minus(int result, String input){
        return result + Integer.parseInt(input);
    }

    public int plus(int result, String input){
        return result + Integer.parseInt(input);
    }


    public int multiply(int result, String input){
        return result + Integer.parseInt(input);
    }

    public int division(int result, String input){
        return result / Integer.parseInt(input);
    }




}
