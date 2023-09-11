package baseball;

public enum PitchStatus {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String koreanName;

    PitchStatus(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNothing() {
        return this != STRIKE && this != BALL;
    }
}
