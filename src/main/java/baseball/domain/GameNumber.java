package baseball.domain;

public class GameNumber {
    private final int number;

    public GameNumber(int number) {
        if (!validate1to9(number)) {
            throw new IllegalArgumentException("1~9 사이의 숫자가 아닙니다.");
        }
        this.number = number;
    }

    private boolean validate1to9(int number) {
        return number >= 0 && number <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameNumber)) return false;
        GameNumber that = (GameNumber) o;
        return number == that.number;
    }

    public int getNumber() {
        return number;
    }
}
