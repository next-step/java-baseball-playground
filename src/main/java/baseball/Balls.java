package baseball;

public class Balls {
    private final Ball[] balls;

    private final static int MAX_LENGTH = 3;

    public Balls(String... num) {
        assert num.length == MAX_LENGTH;
        balls = new Ball[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            assert num[i].length() == 1;
            balls[i] = new Ball(i, num[i]);
        }
    }

    public Balls(String number) {
        assert number.length() == MAX_LENGTH;
        balls = new Ball[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            balls[i] = new Ball(i, number.charAt(i) + "");
        }
    }

    public Ball[] getBalls() {
        return balls;
    }
}
