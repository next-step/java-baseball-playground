package study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열 계산기");
        System.out.println("공백으로 구분하여 원하시는 숫자와 연산자를 입력해주세요.");
        String value = scanner.nextLine();//사용자로부터 공백을 기준으로 문자열을 구분하여 입력 받음
        StringCalculator stringCalculator = new StringCalculator();
        int answer = stringCalculator.calculate(value);
        System.out.println(answer);
    }
}
