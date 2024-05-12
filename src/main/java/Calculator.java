import java.util.Scanner;

/*
 * 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
 * 규칙 2: else 예약어를 쓰지 않는다.
 */
public class Calculator {
    public void calc() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");

        int result = Integer.parseInt(values[0]);
        for (int i = 2; i < values.length; i += 2) {
            result = calc(result, values[i], values[i - 1]);
        }

        System.out.print(result);
    }

    private int calc(int acc, String value, String operator) {
        if (operator.equals("+")) {
            return acc + Integer.parseInt(value);
        }
        if (operator.equals("-")) {
            return acc - Integer.parseInt(value);
        }
        if (operator.equals("*")) {
            return acc * Integer.parseInt(value);
        }
        if (operator.equals("/")) {
            return acc / Integer.parseInt(value);
        }

        throw new IllegalArgumentException(String.format("유효하지 않은 연산식(%s)입니다.", operator));
    }

}
