package baseball;


public class PlayResult {
    private int strike;
    private int ball;

    public void printResult(){
        String result = strikeResult();
        result += ballResult();
        System.out.println(result);
    }

    public String strikeResult() {
        if(strike > 0){
            return strike+"스트라이크";
        }
        return "";
    }
    public String ballResult() {
        if(ball > 0){
            return ball+"볼";
        }
        return "";
    }

    public void play(BallStatus ballStatus){
        if(ballStatus.isStrike()){
            this.strike += 1;
        }
        if(ballStatus.isBall()){
            this.ball += 1;
        }
    }
}
