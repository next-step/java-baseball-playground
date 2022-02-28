package study;

import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class StringCalculator {
    private int sum;
    private String operator;
    @Test
    void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 계산기");
        System.out.println("공백으로 구분하여 원하시는 숫자와 연산자를 입력해주세요.");
        String value = scanner.nextLine();//사용자로부터 공백을 기준으로 문자열을 구분하여 입력 받음
        String[] values = value.split(" ");//사용자로부터 입력받은 문자열을 공백을 기준으로 분리함

        sum = Integer.parseInt(values[0]);
        int i = 1;
        while(i < values.length)
        {
            operator = values[i];
            i++;
            calculate(values[i]);
            i++;
        }
        System.out.println(sum);
    }

    void calculate(String value)
    {
        if(operator.equals("+"))
        {
            sum += Integer.parseInt(value);
            return;
        }
        if(operator.equals("-"))
        {
            sum -= Integer.parseInt(value);
            return;
        }
        if(operator.equals("*"))
        {
            sum *= Integer.parseInt(value);
            return;
        }
        if(operator.equals("/"))
        {
            sum /= Integer.parseInt(value);
            return;
        }
    }
}
