package stringCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Calculator calculator = new Calculator(str);
        int result = calculator.calculate();
        System.out.println(result);
    }
}
