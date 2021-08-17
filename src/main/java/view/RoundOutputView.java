package view;

import dto.RoundOutputDto;

import static java.lang.System.out;

public class RoundOutputView {

    private static final int ZERO = 0;
    private static final String EMPTY = "";

    private RoundOutputView() {
    }

    public static void roundOutput(RoundOutputDto roundOutputDto) {
        String ball = parseBallOutput(roundOutputDto.ball());
        String strike = parseStrikeOutput(roundOutputDto.strike());
        String threeOut = parseThreeOutOutput(roundOutputDto.isThreeOut());
        String result = trimFrom(ball, strike, threeOut);
        out.println(result);
    }

    public static void roundOverOutput() {
        out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static String trimFrom(final String ball, final String strike, final String threeOut) {
        return (ball + strike + threeOut).trim();
    }

    private static String parseBallOutput(final int ball) {
        if (ball != ZERO) {
            return ball + "볼 ";
        }

        return EMPTY;
    }

    private static String parseStrikeOutput(final int strike) {
        if (strike != ZERO) {
            return strike + "스트라이크 ";
        }

        return EMPTY;
    }

    private static String parseThreeOutOutput(final boolean threeOut) {
        if(threeOut) {
            return "낫싱";
        }

        return EMPTY;
    }

}
