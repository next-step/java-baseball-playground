package study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.BinaryOperator;

// https://hch4102.tistory.com/145
public class CalculatorSecond {

	String[] values;

	LinkedList<Double> operands;
	LinkedList<String> operators;

	double result;

	public CalculatorSecond() {
		/*
		 * this() 메소드
		 * 생성자 내부에서만 사용할 수 있으며, 같은 클래스의 다른 생성자를 호출할 때 사용한다.
		 * this() 메소드에 인수(LinkedList, LinkedList)를 전달하면 생성자 중에서 메소드 시그니처가 일치하는 다른 생성자를 찾아 호출ㅊ한다.
		 */

		// The constructor CalculatorSecond(new LinkedList<>(), new LinkedList<>()) is undefined
		this(new LinkedList<>(), new LinkedList<>());
	}

	public CalculatorSecond(LinkedList<Double> operands, LinkedList<String> operators) {
		this.operands = operands;
		this.operators = operators;
	}

	public Double getResult() {
		return result;
	}

	public void calculate() {
		result = operands.poll();
		while (operands.size() != 0) {
			Operator operator = Operator.of(operators.poll());
			result = operator.calculate(result, operands.poll());
		}
	}

	public void enter(String s) {
		values = s.split(" ");
		if (values.length < 3) {
			throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
		}
		for (int i = 0; i < values.length; i++) {
			validate(i, values[i]);
			add(values[i]);
		}
	}

	private void validate(int idx, String value) {
		if (idx % 2 == 0 && !isNumeric(value)) {
			throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
		}
		if (idx % 2 == 1 && isNumeric(value)) {
			throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
		}
	}

	private void add(final String value) {
		if (isNumeric(value)) {
			operands.add(Double.parseDouble(value));
		}
		if (!isNumeric(value)) {
			operators.add(value);
		}
	}

	private boolean isNumeric(String value) {
		if ("".equals(value)) {
			return false;
		}
		return value.matches("-?\\d+(\\.\\d+)?");
	}

	public enum Operator {
		PLUS("+", (e1, e2) -> e1 + e2),
		MINUS("-", (e1, e2) -> e1 - e2),
		MUTIPLE("*", (e1, e2) -> e1 * e2),
		DEVIDE("/", (e1, e2) -> e1 / e2);

		private String operator;
		private BinaryOperator<Double> operating;

		Operator(String operator, BinaryOperator<Double> operating) {
			this.operator = operator;
			this.operating = operating;
		}

		private static Operator of(String operator) {
			return Arrays.stream(Operator.values())
				.filter(value -> value.operator.equals(operator))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("유효한 연산자 형식이 아닙니다."));
		}

		private Double calculate(Double e1, Double e2) {
			return operating.apply(e1, e2);
		}

	}
}
