package baseball.view;

import java.util.List;

public class OutputView {
    public static void printJudgement(List<Integer> judgeResult) {
        int strike = judgeResult.get(0);
        int ball = judgeResult.get(1);
        if (strike != 0 && ball != 0) {
            System.out.println(strike + "스트라이크 " + ball + "볼");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 3) {
            System.out.println("정답을 맞히셨습니다! 게임 종료.");
        }
    }
    public static void printExceptionMessage(String msg){
        System.out.println(msg);
    }
}
