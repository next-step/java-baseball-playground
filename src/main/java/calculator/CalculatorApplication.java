package calculator;

import java.util.Scanner;

public class CalculatorApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserInterface userInterface = new UserInterface(scanner);
		StringCalculator calculator = new StringCalculator();

		String input = userInterface.getInput();
		int result = calculator.run(input);
		userInterface.printResult(result);
	}
}
