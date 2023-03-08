package baseball;

public class BaseBallResult {
    private int strikeCount = 0;
    private int ballCount = 0;
    private int addCount = 0;

    public boolean isNotThing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public void add(BallStatus status) {
        addCount++;

        if( status.isStrike() ){
            strikeCount++;
            return;
        }
        if( status.isBall() ){
            ballCount++;
        }

    }

    public String toStringResult(){
        String result = "";
        if( isNotThing() ){
            return "낫띵";
        }

        if( ballCount > 0 ){
            result += ballCount + "볼 ";
        }

        if( strikeCount > 0 ){
            result += strikeCount + "스트라이크";
        }

        return result;
    }


    public boolean isSuccess() {
        return strikeCount == addCount;
    }

}
