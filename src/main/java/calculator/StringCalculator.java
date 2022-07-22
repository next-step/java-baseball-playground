package calculator;

import java.util.Scanner;
import java.util.Stack;

public class StringCalculator {
	private static final char ADD = '+';
	private static final char SUBTRACT = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVIDER = '/';

	private final Scanner scanner;

	public StringCalculator(Scanner scanner) {
		this.scanner = scanner;
	}

	public void run() {
		String[] polynomial = getTerms();
		int result = calculator(polynomial);

		// Output layer 로 옮겨야 함
		System.out.println("result = " + result);
	}

	public int calculator(String[] terms) {
		Stack<String> buffer = new Stack<>();
		for (String term : terms) {
			String element = term;
			if (!buffer.isEmpty() && isInteger(element)) {
				buffer.push(element);
				element = calculate(buffer);
			}

			buffer.push(element);
		}

		return Integer.parseInt(buffer.pop());
	}

	public String calculate(Stack<String> buffer) {
		int second = Integer.parseInt(buffer.pop());
		char operator = buffer.pop().charAt(0);
		int first = Integer.parseInt(buffer.pop());

		if (operator == ADD) {
			return add(first, second);
		} else if (operator == SUBTRACT) {
			return subtract(first, second);
		} else if (operator == MULTIPLY) {
			return multiply(first, second);
		} else if (operator == DIVIDER) {
			return divide(first, second);
		}

		throw new IllegalArgumentException("invalid operator");
	}

	private String divide(int num1, int num2) {
		if (num2 == 0) {
			throw new ArithmeticException("can not divide by zero");
		}

		return String.valueOf(num1 / num2);
	}

	private String multiply(int num1, int num2) {
		return String.valueOf(num1 * num2);
	}

	private String subtract(int num1, int num2) {
		return String.valueOf(num1 - num2);
	}

	private String add(int num1, int num2) {
		return String.valueOf(num1 + num2);
	}

	public boolean isInteger(String element) {
		try {
			int parsed = Integer.parseInt(element);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * input layer 로 옮겨야 함
	 *
	 * @return polynomial
	 */
	public String[] getTerms() {
		String readLine = scanner.nextLine().trim();
		/**
		 * validate 추가 해야 함
		 * 1. 맨 마지막 요소는 숫자여야 함
		 * 2. 숫자와 연산자가 번갈아가며 위치하는지 확인해야 함
		 */
		return readLine.split(" ");
	}
}
