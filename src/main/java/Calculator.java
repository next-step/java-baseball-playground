import java.util.Scanner;

public class Calculator {
    public int calculator(String value) {
        String[] values = isBlank(value);
        int result = stringToInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calc(values[i],result,stringToInt(values[i+1]));
        }
        return result;
    }
    public int calc(String value, int result, int nextNumber) {
        switch(value){
            case "+" :
                return sum(result, nextNumber);
            case "-" :
                return sub(result, nextNumber);
            case "/" :
                return divide(result, nextNumber);
            case "*" :
                return multiply(result, nextNumber);
            default:
                return -1;
        }


    }

    public String[] isBlank(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("입력값을 확인해 주세요");
        }
        return value.split(" ");
    }

    public int stringToInt(String value) {
        return Integer.parseInt(value);
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0;
        }
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}
