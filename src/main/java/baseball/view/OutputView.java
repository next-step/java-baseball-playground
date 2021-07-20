package baseball.view;

import baseball.BallGameResult;
import baseball.BallGameRunner;
import baseball.BallStatus;

public class OutputView {

    public static final String TELL_NOTHING = "낫싱";
    public static final String TELL_BALLS = "볼";
    public static final String TELL_STRIKES = "스트라이크";
    public static final String TELL_IS_END_3_STRIKES = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    private OutputView(){}

    public static final void showGameResult(BallGameRunner ballGameRunner){
        BallGameResult ballGameResult = ballGameRunner.run();
        // 함부로 if 조건절 static변환 안됨. 그리고 if else if else 안하면 중복조건 발생 (S&B S)
        if (ballGameResult.isZero(BallStatus.STRIKE) && ballGameResult.isZero(BallStatus.BALL)) {
            System.out.print(TELL_NOTHING);
        }
        else if (ballGameResult.isZero(BallStatus.STRIKE) && !ballGameResult.isZero(BallStatus.BALL)) {
            System.out.print(String.format("%s"+TELL_BALLS,
                    ballGameResult.getCount(BallStatus.BALL)));
        }
        else if (!ballGameResult.isZero(BallStatus.STRIKE) && ballGameResult.isZero(BallStatus.BALL)) {
            System.out.print(String.format("%s"+ TELL_STRIKES,
                    ballGameResult.getCount(BallStatus.STRIKE)));
        }
        else {
            System.out.print(String.format("%s"+TELL_BALLS+" %s"+TELL_STRIKES,
                    ballGameResult.getCount(BallStatus.BALL),
                    ballGameResult.getCount(BallStatus.STRIKE)));
        }
    }


    public static boolean showEndResult(BallGameRunner ballGameRunner) {
        if (ballGameRunner.isEnd()) {
            System.out.print(TELL_IS_END_3_STRIKES);
            return InputView.askNewGame();
        }
        return false;
    }
}
