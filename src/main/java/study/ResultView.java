package study;

import java.util.List;

public class ResultView {

    public void result(List<Status> statusList) {
        int strikeCount = (int) statusList.stream()
                .filter(status -> status == Status.STRIKE)
                .count();

        int ballCount = (int) statusList.stream()
                .filter(status -> status == Status.BALL)
                .count();
        String output = "";
        if (ballCount != 0)
            output += ballCount + "볼 ";
        if (strikeCount != 0)
            output += strikeCount + "스트라이크 ";
        System.out.println(output);

        if (strikeCount == 3)
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
