package study;

import java.util.List;

public class ResultView {

    public static final String BALL_MESSAGE = "볼 ";
    public static final String STRIKE_MESSAGE = "스트라이크 ";
    public static final String COMPLETE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void result(List<Status> statusList) {
        int strikeCount = (int) statusList.stream()
                .filter(status -> status == Status.STRIKE)
                .count();

        int ballCount = (int) statusList.stream()
                .filter(status -> status == Status.BALL)
                .count();
        String output = "";
        if (ballCount != 0)
            output += ballCount + BALL_MESSAGE;
        if (strikeCount != 0)
            output += strikeCount + STRIKE_MESSAGE;
        System.out.println(output);

        if (strikeCount == 3)
            System.out.println(COMPLETE_MESSAGE);
    }
}
