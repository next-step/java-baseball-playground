package domain;

import java.util.Arrays;

public enum GameStatus {
    PLAY("1"),
    OVER("2");

    private final String status;

    GameStatus(final String status) {
        this.status = status;
    }

    public static GameStatus from(final String status) {
        return Arrays.stream(GameStatus.values())
                .filter(value -> value.status.equals(status))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 게임의 상태입니다"));
    }
}
