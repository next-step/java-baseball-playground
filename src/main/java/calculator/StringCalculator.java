package calculator;

import java.util.Stack;

public class StringCalculator {
	private static final char ADD = '+';
	private static final char SUBTRACT = '-';
	private static final char MULTIPLY = '*';
	private static final char DIVIDER = '/';

	public int run(String userInput) {
		String[] polynomial = getTerms(userInput);
		int result = calculator(polynomial);

		return result;
	}

	public int calculator(String[] terms) {
		Stack<String> buffer = new Stack<>();
		for (String term : terms) {
			calculateAndAddResult(buffer, term);
		}

		return Integer.parseInt(buffer.pop());
	}

	private void calculateAndAddResult(Stack<String> buffer, String term) {
		if (!buffer.isEmpty() && isInteger(term)) {
			buffer.push(term);
			term = calculate(buffer);
		}

		buffer.push(term);
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

	public String divide(int num1, int num2) {
		if (num2 == 0) {
			throw new ArithmeticException("can not divide by zero");
		}

		return String.valueOf(num1 / num2);
	}

	public String multiply(int num1, int num2) {
		return String.valueOf(num1 * num2);
	}

	public String subtract(int num1, int num2) {
		return String.valueOf(num1 - num2);
	}

	public String add(int num1, int num2) {
		return String.valueOf(num1 + num2);
	}

	public boolean isInteger(String element) {
		try {
			Integer.parseInt(element);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * input layer 로 옮겨야 함
	 * 입력 받는 것 자체는 input layer 에서 하고, 가공하는 것을 여기서 진행
	 * 따라서 getTerms(String input) 으로 input parameter 로 받으면 좋을 것 같다
	 *
	 * @return polynomial
	 */
	public String[] getTerms(String userInput) {
		/**
		 * validate 추가 해야 함
		 * 1. 맨 마지막 요소는 숫자여야 함
		 * 2. 숫자와 연산자가 번갈아가며 위치하는지 확인해야 함
		 */
		return userInput.split(" ");
	}
}
