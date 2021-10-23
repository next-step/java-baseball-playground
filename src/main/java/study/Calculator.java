package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private String[] operationTypes = {"+", "-", "*", "/"};

    public int StringCalculator(String input) throws Exception {

        ArrayList<String> values = new ArrayList<>(Arrays.asList(input.split(" ")));
        ArrayList<String> operations = new ArrayList<>();

        int result = Integer.parseInt(values.remove(0));

        if(values.isEmpty()) {
            return result;
        }

        for (String value : values) {

            if(isOperation(value)) {
                operations.add(value);
                continue;
            }

            int valueNum = Integer.parseInt(value);
            result = OperationCalculator(result, operations.remove(0), valueNum);

        }
        return result;
    }

    public int OperationCalculator(int num1, String operation, int num2) throws Exception{

            if(operation.equals("+")){
                return num1 + num2;
            }
            if(operation.equals("-")){
                return num1 - num2;
            }
            if(operation.equals("*")){
                return num1 * num2;
            }
            if(operation.equals("/")){
                return num1 / num2;
            }

        throw new Exception("잘못 입력하셨습니다.");

    }

    private boolean isOperation(String value) {
        for (String operationType : operationTypes) {
           if(operationType.equals(value)) return true;
        }
        return false;
    }


}
