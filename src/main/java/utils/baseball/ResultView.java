package utils.baseball;

public class ResultView {
    public static void printGameResult(BullsAndCows game) {
        String result = getGameResult(game);
        System.out.println(result);
    }

    private static String getGameResult(BullsAndCows game) {
        int strikeCount = game.getStrikeCount();
        int ballCount = game.getBallCount();
        int numberLength = game.getNumberLength();

        String result = "";
        if(strikeCount > 0) {
            result +=  strikeCount + "스트라이크";
        }
        if(ballCount > 0) {
            result += ballCount + "볼";
        } else if (game.isNothing()) {
            result = "낫싱";
        } else if(game.isAllStrike()) {
            result = numberLength + "스트라이크\n";
            result += numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        return result;
    }

}
