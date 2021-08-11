package study;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

	int answer;
	String operator;
	Scanner scanner = new Scanner(System.in);

	public Calculator() {
		Start();
	}

	public void Start() {
		System.out.println("연산식 입력 : ");

		String formula = scanner.nextLine();
		String[] values = split(formula);

		answer = Integer.parseInt(values[0]);

		for (int i = 1; i < values.length; i++) {
			if (isOperator(values[i])) {
				operator = values[i];
			} else {
				operating(values[i]);
			}

		}

		System.out.println(answer);
	}

	private void operating(String value) {
		int number = Integer.parseInt(value);

		if (operator.equals("+")) {
			answer += number;
		} else if (operator.equals("-")) {
			answer -= number;
		} else if (operator.equals("/")) {
			answer /= number;
		} else if (operator.equals("*")) {
			answer *= number;
		}
	}

	private boolean isOperator(String value) {
		return Pattern.matches("[+-/*]", value);
	}

	public String[] split(String formula) {
		return formula.split(" ");
	}

	public static void main(String[] args) {
		Calculator cal = new Calculator();
	}
}
