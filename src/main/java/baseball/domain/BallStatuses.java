package baseball.domain;

import java.util.List;

public class BallStatuses {

    public static final int BALL_STATUSES_SIZE = 3;

    private List<BallStatus> statuses;

    private BallStatuses(final List<BallStatus> statuses) {
        this.statuses = statuses;
    }

    public static BallStatuses from(final List<BallStatus> statuses) {
        validate(statuses);
        return new BallStatuses(statuses);
    }

    private static void validate(final List<BallStatus> statuses) {
        if (statuses.size() != BALL_STATUSES_SIZE) {
            throw new IllegalArgumentException("숫자야구 상태의 길이는 3이어야 합니다");
        }
    }

    public int countStrike() {
        return (int) statuses.stream()
                .filter(BallStatus::isStrike)
                .count();
    }

    public int countBall() {
        return (int) statuses.stream()
                .filter(BallStatus::isBall)
                .count();
    }
}
