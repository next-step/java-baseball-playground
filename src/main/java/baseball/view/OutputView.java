package baseball.view;

import baseball.BallGameResult;
import baseball.BallGameRunner;
import baseball.BallStatus;

public class OutputView {

    private OutputView(){}

    public static final void showGameResult(BallGameRunner ballGameRunner){
        BallGameResult ballGameResult = ballGameRunner.run();
        // 함부로 if 조건절 static변환 안됨. 그리고 if else if else 안하면 중복조건 발생 (S&B S)
        if (ballGameResult.isZero(BallStatus.STRIKE) && ballGameResult.isZero(BallStatus.BALL)) {
            System.out.print("낫싱");
        }
        else if (ballGameResult.isZero(BallStatus.STRIKE) && !ballGameResult.isZero(BallStatus.BALL)) {
            System.out.print(String.format("%s볼",
                    ballGameResult.getCount(BallStatus.BALL)));
        }
        else if (!ballGameResult.isZero(BallStatus.STRIKE) && ballGameResult.isZero(BallStatus.BALL)) {
            System.out.print(String.format("%s스트라이크",
                    ballGameResult.getCount(BallStatus.STRIKE)));
        }
        else {
            System.out.print(String.format("%s볼 %s스트라이크",
                    ballGameResult.getCount(BallStatus.BALL),
                    ballGameResult.getCount(BallStatus.STRIKE)));
        }
    }


    public static boolean showEndResult(BallGameRunner ballGameRunner) {
        if (ballGameRunner.isEnd()) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            return InputView.askNewGame();
        }
        return false;
    }
}
