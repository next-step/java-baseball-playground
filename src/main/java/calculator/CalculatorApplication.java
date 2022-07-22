package calculator;

import java.util.Scanner;

public class CalculatorApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringCalculator application = new StringCalculator(scanner);

		application.run();
	}
}
