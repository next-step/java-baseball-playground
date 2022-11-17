/**
 * 기능 정리 :
 *  1. nextLine()을 사용해 공백을 포함하여 입력받는다.
 *  2. split()을 사용해 공백을 기준으로 문자열들을 분리한다.
 *  3. 분리된 String 문자열들을 Integer.parseInt()을 사용해 형변환 해준다.
 *  4. 들어온 문자를 순서대로 계산해준다.
 *  5. 공백인지 아닌지 검사.
 *  6. 결과 반환.
 */

public class StringCalculator {
    public String[] split(String s) {
        return s.split(" ");
    }

    public int toInt(String s) {
        return Integer.parseInt(s);
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        try {
            return a / b;
        }
        catch (ArithmeticException e) {
            System.out.println("0으로 나눌수 없슴미다");
        }

        return 0;
    }

    public int calculate(int a, char c, int b) {

        if(c == '+')
            return add(a , b);

        else if(c == '-')
            return sub(a, b);

        else if(c == '*')
            return  mul(a, b);

        else if(c == '/')
            return divide(a, b);

        else
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
    }
}
