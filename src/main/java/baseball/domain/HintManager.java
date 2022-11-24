package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HintManager {
    Map<Hint, Integer> hintData;

    public HintManager() {
        this.hintData = new HashMap<>();
        hintData.put(Hint.BALL, 0);
        hintData.put(Hint.STRIKE, 0);
    }

    public void updateStrike() {
        Integer before = hintData.get(Hint.STRIKE);
        hintData.put(Hint.STRIKE, before + 1);
    }

    public void updateBall() {
        Integer before = hintData.get(Hint.BALL);
        hintData.put(Hint.BALL, before + 1);
    }

    public int getStrikeCount() {
        return hintData.get(Hint.STRIKE);
    }

    public int getBallCount() {
        return hintData.get(Hint.BALL);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HintManager)) {
            return false;
        }
        HintManager that = (HintManager) o;
        return Objects.equals(hintData, that.hintData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hintData);
    }
}
