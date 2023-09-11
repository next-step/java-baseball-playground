package newBaseball;

public class PitchResult {
    private int strikeCount;
    private int ballCount;

    public void updateCount(PitchStatus pitchStatus) {
        if (pitchStatus.isStrike()) {
            strikeCount++;
        }
        if (pitchStatus.isBall()) {
            ballCount++;
        }
    }

    public String report() {
        if (strikeCount != 0 && ballCount != 0) {
            return String.format("%d%s %d%s", ballCount, PitchStatus.BALL.getKoreanName()
                    , strikeCount, PitchStatus.STRIKE.getKoreanName());
        }
        if (strikeCount != 0) {
            return String.format("%d%s", strikeCount, PitchStatus.STRIKE.getKoreanName());
        }
        if (ballCount != 0) {
            return String.format("%d%s", ballCount, PitchStatus.BALL.getKoreanName());
        }
        return PitchStatus.NOTHING.getKoreanName();
    }

    public boolean isStrikeOut(int totalNumbers) {
        return totalNumbers == strikeCount;
    }
}
