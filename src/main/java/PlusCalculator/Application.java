package PlusCalculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("음수를 제외한 숫자를 콤마 또는 콜론으로 구분하여 입력하세요.");
        System.out.println(PlusCalculator.calculate(NumbersParser.parse(scanner.nextLine())));
    }
}
