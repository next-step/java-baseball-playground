package stringCalculator;

import java.util.Scanner;

import static stringCalculator.StringCalc.calculate;

public class StringCalculatorMain {
    //psvm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입력하세요");
        String input = scanner.nextLine();
        System.out.print(calculate(input));
    }
}
