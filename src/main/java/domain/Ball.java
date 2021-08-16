package domain;

public class Ball {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 3;

    private final int number;
    private final int position;

    public static Ball of(final int number, final int position) {
        validate(number, position);
        return new Ball(number, position);
    }

    private Ball(final int number, final int position) {
        this.number = number;
        this.position = position;
    }

    private static void validate(final int number, final int position) {
        if (number <= MIN_NUMBER || number > MAX_NUMBER)  {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해야 합니다");
        }

        if (position <= MIN_POSITION || position > MAX_POSITION) {
            throw new IllegalArgumentException("1~3 사이의 위치를 입력해야 합니다");
        }
    }

    public boolean hasSameNumber(final Ball other) {
        return number == other.number;
    }

    public boolean hasSamePosition(final Ball other) {
        return position == other.position;
    }
}
