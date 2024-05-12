package baseball.view;

import baseball.core.GameResult;

// 결과를 보여주는 기능
public class ResultView {
    public void output(GameResult gameResult) {
        System.out.println(gameResult.getGameResult());
    }
}