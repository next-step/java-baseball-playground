package baseball;

public class Ball {
    private final Integer idx;
    private final Integer number;

    public Ball(int idx, String number) {
        this.idx = idx;
        this.number = Integer.parseInt(number);
    }

    public Integer getIdx() {
        return idx;
    }

    public Integer getNumber() {
        return number;
    }
}
