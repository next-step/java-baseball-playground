package baseball.model;

public class BaseballNumber {
    private int number;

    public BaseballNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < 1 || 9 < number) {
            throw new IllegalArgumentException();
        }
    }
}