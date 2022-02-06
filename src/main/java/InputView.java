public class InputView {
	private final Integer[] digits;

	public InputView(Integer input) {
		digits = new Integer[3];
		digits[0] = input / 100;
		digits[1] = (input % 100) / 10;
		digits[2] = (input % 100) % 10;
	}

	public Integer[] getDigits() {
		return digits;
	}
}
