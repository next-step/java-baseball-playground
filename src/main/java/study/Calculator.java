package study;

import static java.lang.Integer.*;

public class Calculator {

    public int calculateSeparateString(String str) {
        String[] strs = str.split(" ");
        int result = parseInt(strs[0]);

        for (int i = 1; i < strs.length; i += 2) {
            result = calculation(result, strs[i], parseInt(strs[i + 1]));
        }
        return result;
    }


    private int calculation(int result, String operation, int number) {
        return switch (operation) {
            case "+" -> result + number;
            case "-" -> result - number;
            case "*" -> result * number;
            case "/" -> result / number;
            default -> throw new IllegalArgumentException("지원하지 안는 연산자 입니다.");
        };
    }
}
