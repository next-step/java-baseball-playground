package study;

import java.util.Scanner;

public class StringCalculatorClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringFormula = scanner.nextLine();

        StringCalculator stringCalculator = new StringCalculator();
        String result = stringCalculator.calculate(stringFormula);

        System.out.println("result is " + result);
    }
}
