package baseball.domain;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NONE("낫싱");

    private String a;

    Hint(String a) {
        this.a = a;
    }
}
