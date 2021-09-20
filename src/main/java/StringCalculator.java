import java.util.Scanner;

public class StringCalculator {

    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String[] split(String value) {
        return value.split(" ");
    }

    public int calculator(String[] values) {
        int start = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            start = calculator(start, Integer.parseInt(values[i + 1]), values[i]);
        }
        return start;
    }

    private int calculator(int num1, int num2, String sign) {
        int result = 0;
        switch (sign) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
