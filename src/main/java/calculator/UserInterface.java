package calculator;

import java.util.Scanner;

public class UserInterface {
	private final Scanner scanner;

	public UserInterface(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getInput() {
		return scanner.nextLine();
	}

	public void printResult(int result) {
		System.out.println("result = " + result);
	}
}
