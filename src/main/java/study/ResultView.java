package study;

import java.util.Arrays;

public class ResultView {

    public void result(Status[] result) {
        int strikeCount = (int) Arrays.stream(result).filter(status -> status == Status.STRIKE).count();
        int ballCount = (int) Arrays.stream(result).filter(status -> status == Status.BALL).count();
        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
    }
}
