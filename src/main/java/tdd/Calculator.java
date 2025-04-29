package tdd;

public class Calculator {

    public static int calculator (String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }

        String[] values = input.split(" ");

        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i = i + 2) {

            String operator = values[i];
            int number = parseInt(values[i + 1]);

            result = operate(result, operator, number);
        }

        return result;
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("숫자가 아닌 값이 입력 되었습니다." + input);
        }
    }

    private static int operate(int result, String operator, int number) {
        switch (operator) {
            case "+" :
                return result += number;

            case "-" :
                return result -= number;

            case "*" :
                return result *= number;

            case "/" :
                return result /= number;

            default :
                throw new IllegalArgumentException("잘못된 연산자 입니다. " + operator);
        }
    }
}
