package study;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorBasic {

	int answer;
	String operator;
	Scanner scanner = new Scanner(System.in);

	public void Start() {
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
	}

	public void operating(String value) {
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

	public boolean isOperator(String value) {
		return Pattern.matches("[+-/*]", value);
	}

	public String[] split(String formula) {
		return formula.split(" ");
	}

	public static void main(String[] args) {
		CalculatorBasic cal = new CalculatorBasic();
		cal.Start();
	}
}
