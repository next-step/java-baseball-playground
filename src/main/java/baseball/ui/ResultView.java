package baseball.ui;

import baseball.domain.GameStatus;

public class ResultView {
    public boolean giveResult(GameStatus gameStatus) {
        if (gameStatus.getBall() == 3) {
            System.out.println("낫싱");
            return true;
        }
        if (gameStatus.getStrike() == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        System.out.println(gameStatus.getBall()+"볼 "+gameStatus.getStrike()+"스트라이크");
        return true;
    }
}
