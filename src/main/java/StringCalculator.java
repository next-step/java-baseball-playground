import java.util.HashSet;
import java.util.Set;

public class StringCalculator {

	private static final Set<String> validSet;

	static {
		validSet = new HashSet() {
			{
				add("0");
				add("1");
				add("2");
				add("3");
				add("4");
				add("5");
				add("6");
				add("7");
				add("8");
				add("9");
				add("+");
				add("*");
				add("/");
				add("-");
				add(" ");
			}
		};
	}

	public String calculate(String value) throws Throwable {
		String[] values = value.split(" ");
		validateValues(values);

		String result = calculateWithTwoArgument(values[1], values[0], values[2]);

		for (int i = 3; i < values.length; i += 2) {
			String operator = values[i];
			result = calculateWithTwoArgument(operator, result, values[i + 1]);
		}

		return result;
	}

	private String calculateWithTwoArgument(String operator, String arg1, String arg2) {
		if (operator.equals("+")) {
			return add(arg1, arg2);
		}
		if (operator.equals("*")) {
			return multiply(arg1, arg2);
		}
		if (operator.equals("-")) {
			return subtract(arg1, arg2);
		}
		if (operator.equals("/")) {
			return divide(arg1, arg2);
		}
		return "";
	}


	private String add(String args1, String args2) {
		return String.valueOf(Integer.parseInt(args1) + Integer.parseInt(args2));
	}

	private String subtract(String args1, String args2) {
		return String.valueOf(Integer.parseInt(args1) - Integer.parseInt(args2));
	}

	private String multiply(String args1, String args2) {
		return String.valueOf(Integer.parseInt(args1) * Integer.parseInt(args2));
	}

	private String divide(String args1, String args2) {
		return String.valueOf(Integer.parseInt(args1) / Integer.parseInt(args2));
	}

	private void validateValues(String[] values) {
		for (String value : values) {
			if (validSet.contains(value)) {
				return;
			}

			try {
				Double.parseDouble(value);
			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid value");
			}
		}
	}

}
