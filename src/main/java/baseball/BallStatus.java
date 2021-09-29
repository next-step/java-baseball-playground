package baseball;

import org.jetbrains.annotations.NotNull;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public static BallStatus isNotThing() {
        return NOTHING;
    }
}
