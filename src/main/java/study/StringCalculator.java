package study;

public class StringCalculator {
    public String[] split(String s) {
        return s.split(" ");
    }

    public int toInt(String s) {
        return Integer.parseInt(s);
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int sub(int a, int b) {
        return a - b;
    }

    private int mul(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        if(b == 0)
            throw new ArithmeticException("divide By zero");

        return a / b;
    }

    public int calculate(int a, char c, int b) {

        if (c == '+')
            return add(a, b);

        else if (c == '-')
            return sub(a, b);

        else if (c == '*')
            return mul(a, b);

        else if (c == '/')
            return divide(a, b);

        else
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
    }

    public int calculateString(String[] strs) {
        int result = toInt(strs[0]);

        for (int i = 0; i < strs.length - 2; i += 2) {
            result = calculate(result, strs[i + 1].charAt(0), toInt(strs[i + 2]));
        }

        return result;
    }
}
