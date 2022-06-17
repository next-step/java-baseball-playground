package study.baseball;

import java.util.Objects;

public class PlayGameResult {

    private int ballCount;
    private int strikeCount;

    public PlayGameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public void addBallCount() {
        ballCount++;
    }

    public void addStrikeCount() {
        strikeCount++;
    }

    public void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayGameResult that = (PlayGameResult) o;
        return ballCount == that.ballCount && strikeCount == that.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballCount, strikeCount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount).append("볼");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append("포볼");
        }
        return sb.toString();
    }
}
