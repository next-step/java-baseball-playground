package baseball.view;

import baseball.dto.RoundOutputDto;


public class RoundOutputConsoleView implements RoundOutputView{

    private static final int ZERO = 0;
    private static final String EMPTY = "";

    private RoundOutputConsoleView() {
    }

    public static RoundOutputView getInstance() {
        return new RoundOutputConsoleView();
    }

    @Override
    public void roundOutput(RoundOutputDto roundOutputDto) {
        String ball = parseBallOutput(roundOutputDto.ball());
        String strike = parseStrikeOutput(roundOutputDto.strike());
        String threeOut = parseThreeOutOutput(roundOutputDto.isThreeOut());
        String result = trimFrom(ball, strike, threeOut);
        System.out.println(result);
    }

    @Override
    public void roundOverOutput() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String trimFrom(final String ball, final String strike, final String threeOut) {
        return (ball + strike + threeOut).trim();
    }

    private String parseBallOutput(final int ball) {
        if (ball != ZERO) {
            return ball + "볼 ";
        }

        return EMPTY;
    }

    private String parseStrikeOutput(final int strike) {
        if (strike != ZERO) {
            return strike + "스트라이크 ";
        }

        return EMPTY;
    }

    private String parseThreeOutOutput(final boolean threeOut) {
        if(threeOut) {
            return "낫싱";
        }

        return EMPTY;
    }

}
