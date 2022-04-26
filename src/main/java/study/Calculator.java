package study;

public class Calculator {

    public int calculateSeparateString(String str) {
        String[] strs = str.split(" ");
        validationLength(strs.length);

        int result = parseInt(strs[0]);

        for (int i = 1; i < strs.length; i += 2) {
            result = calculate(result, strs[i], parseInt(strs[i + 1]));
        }
        return result;
    }

    private void validationLength(int length) {
        if (length % 2 == 0) throw new IllegalArgumentException("공백을 기준으로 홀수여야 합니다.");
    }

    private int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("짝수에는 숫자만 존재해야 합니다.");
        }

    }


    private int calculate(int result, String operation, int number) {
        return switch (operation) {
            case "+" -> add(result, number);
            case "-" -> subtraction(result, number);
            case "*" -> multiplication(result, number);
            case "/" -> division(result, number);
            default -> throw new IllegalArgumentException("지원하지 안는 연산자 입니다.");
        };
    }

    private int division(int result, int number) {
        if(number == 0) throw new IllegalStateException("0으로는 나눌수 없습니다.");
        return result / number;
    }

    private int multiplication(int result, int number) {
        return result * number;
    }

    private int subtraction(int result, int number) {
        return result - number;
    }

    private int add(int result, int number) {
        return result + number;
    }
}
