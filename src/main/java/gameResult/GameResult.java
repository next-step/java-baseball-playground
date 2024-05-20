package gameResult;

import utils.ConstantUtils;

public class GameResult {

    private int ball;
    private int strike;

    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public GameResult() {
    }

    public static GameResult createDefaultGameResult(){
        GameResult gameResult = new GameResult();
        gameResult.strike = 0;
        gameResult.ball = 0;
        return gameResult;
    }

    public boolean isWin() {
        return strike == ConstantUtils.GAME_NUM_LENGTH;
    }

    public void printGameResult() {
        if(ball == 0) {
            System.out.println(strike + "스트라이크");
            printWhenWinGame();
            return;
        }

        if(strike == 0) {
            System.out.println(ball +"볼");
            return;
        }

        System.out.println(ball + "볼 " + strike +"스트라이크");
    }

    void printWhenWinGame() {
        if(isWin()) {
            System.out.println(ConstantUtils.GAME_NUM_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }

    public int getBall(){
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }
}
