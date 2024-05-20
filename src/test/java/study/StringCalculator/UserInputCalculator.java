package study.StringCalculator;

import org.junit.jupiter.api.BeforeEach;

import java.util.Scanner;

public class UserInputCalculator {

    private final StringCalculator stringCalculator;

    UserInputCalculator(StringCalculator stringCalculator) {
        this.stringCalculator = stringCalculator;
    }

    int userInputCalculate(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        return stringCalculator.calculator(input);
    }
}
