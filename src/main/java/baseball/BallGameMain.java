package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BallGameMain {

    public static void main(String[] args) {

        SystemBalls systemBalls = new SystemBalls(new BallsGenerator());
        System.out.print("-----system Ball 생성\n");
        System.out.print(systemBalls.getSystemBallsList().get(0).getBallNum() + "," +
                systemBalls.getSystemBallsList().get(1).getBallNum() + "," +
                systemBalls.getSystemBallsList().get(2).getBallNum());
        String input = InputView.askInput();
        BallGameRunner ballGameRunner = new BallGameRunner(systemBalls, input);
        System.out.print("-----ballGameRunner 생성\n");
        if (OutputView.showEndResult(ballGameRunner)) {
            System.out.print("-----ballGameRunner 끝\n");
            BallGameMain.main(args);
            System.out.print("-----ballGameRunner 새것\n");
        }
        while (!ballGameRunner.isEnd()) {
            OutputView.showGameResult(ballGameRunner);
            String reInput = InputView.askInput();
            ballGameRunner = new BallGameRunner(systemBalls, reInput);
            System.out.print("-----system Ball 유지\n");
            if (OutputView.showEndResult(ballGameRunner)) {
                System.out.print("-----ballGameRunner 다시하니 끝\n");
                BallGameMain.main(args);
                System.out.print("-----ballGameRunner 다시하니 새것\n");
            }
        }

    }
}
