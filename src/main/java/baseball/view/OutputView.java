package baseball.view;

import baseball.model.dto.BaseballGameResultDto;

public class OutputView {

    public void result(BaseballGameResultDto gameResult) {
        String outputMessage = ballsToString(gameResult.getBalls()) +
                strikesToString(gameResult.getStrikes()) +
                nothingToString(gameResult.getNothing());

        System.out.println(outputMessage);
    }

    public void complete() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void exception(String outputMessage) {
        System.out.println(outputMessage);
    }

    private String ballsToString(Integer balls) {
        if (balls > 0) {
            return balls + "볼 ";
        }
        return "";
    }

    private String strikesToString(Integer strikes) {
        if (strikes > 0) {
            return strikes + "스트라이크";
        }
        return "";
    }

    private String nothingToString(Boolean nothing) {
        if (nothing) {
            return "낫싱";
        }
        return "";
    }
}
