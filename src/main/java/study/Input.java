package study;

import java.util.Scanner;

public class Input {

    static int getFirstValue(Scanner scan) {
        System.out.println("첫 번째 값 입력 : ");
        int first = scan.nextInt();
        System.out.println(first);
        return first;
    }

    static String getSymbol(Scanner scan) {
        System.out.println("사칙연산 기호 : ");
        String symbol = scan.next();
        System.out.println(symbol);
        return symbol;
    }
    
    static int getSecondValue(Scanner scan) {
        System.out.println("두 번째 값 입력 : ");
        int second = scan.nextInt();
        System.out.println(second);
        return second;
    }
}
