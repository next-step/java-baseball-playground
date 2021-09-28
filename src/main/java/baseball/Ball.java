package baseball;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Ball {
    private final int postion;
    private final int num;

    public Ball(int position, int num) {
        this.postion = position;
        this.num = num;
    }

    public BallStatus play(Ball com) {

        if (isStrike(com)) {
            return BallStatus.STRIKE;
        }

        if (isBall(com.num, this.num)) {
            return BallStatus.BALL;
        }
        return BallStatus.isNotThing();
    }

    private boolean isBall(int num, int p) {
        return num == p;
    }

    private boolean isStrike(Ball com) {
        return isBall(com.postion, this.postion) && isBall(com.num, this.num);
    }
}
