package checker;

import java.util.Objects;

public class CountVO {
    private int strikeCount = 0;
    private int ballCount = 0;
    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public CountVO() {
    }

    public CountVO(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public void increaseStrikeCount(){
        this.strikeCount++;
    }

    public void increaseBallCount(){
        this.ballCount++;
    }

    public boolean isCorrect(){
        return this.strikeCount == 3;
    }

    public boolean isNothing(){
        return this.strikeCount == 0 && this.ballCount == 0;
    }

    public boolean isNoStrike(){
        return this.strikeCount == 0;
    }

    public boolean isNoBall(){
        return this.ballCount == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountVO countVO = (CountVO) o;
        return strikeCount == countVO.strikeCount && ballCount == countVO.ballCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount);
    }
}
