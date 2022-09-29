package baseball.domain;

import static baseball.domain.Pitcher.BALL_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Referee {

    public static final String NOTHING_STRING = "낫싱";
    public static final String STRIKE_STRING = "스트라이크";
    public static final String BALL_STRING = "볼";
    public static final String GAME_END_STRING = "3스트라이크";
    public static final String CONTINUED_STRING = "1";
    public static final String END_STRING = "2";
    static class RefereeCount {
        int ballCount = 0;
        int strikeCount = 0;
    }
    public String judge(String ball, String swing) {
        RefereeCount refereeCount = new RefereeCount();
        StringBuilder result = new StringBuilder();
        counting(ball, refereeCount, swing);
        if (isNothing(refereeCount)) {
            return NOTHING_STRING;
        }
        addResultString(refereeCount, result);
        return result.toString();
    }

    private static void addResultString(RefereeCount refereeCount, StringBuilder result) {
        if (hasBall(refereeCount)) {
            result.append(refereeCount.ballCount).append(BALL_STRING);
        }
        if (hasStrike(refereeCount)) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(refereeCount.strikeCount).append(STRIKE_STRING);
        }
    }

    private static boolean hasStrike(RefereeCount refereeCount) {
        return refereeCount.strikeCount != 0;
    }

    private static boolean hasBall(RefereeCount refereeCount) {
        return refereeCount.ballCount != 0;
    }

    private static boolean isNothing(RefereeCount refereeCount) {
        return refereeCount.ballCount == 0 && refereeCount.strikeCount == 0;
    }

    private static void counting(String ball, RefereeCount refereeCount, String swing) {
        String[] ballSplit = ball.split("");
        String[] swingSplit = swing.split("");
        for (int i = 0; i < BALL_LENGTH; i++) {
            if (ballSplit[i].equals(swingSplit[i])) {
                refereeCount.strikeCount++;
                continue;
            }
            if (ball.contains(swingSplit[i])) {
                refereeCount.ballCount++;
            }
        }
    }

    public void startGame() {
        boolean isContinued = true;
        Pitcher pitcher = new Pitcher();
        String ball = pitcher.throwBall();
        do {
            String judgement = playGame(ball);
            if (GAME_END_STRING.equals(judgement)) {
                isContinued = getContinued();
                ball = getString(isContinued, pitcher, ball);
            }
        } while (isContinued);
    }

    private String playGame(String ball) {
        Batter batter = new Batter();
        String swing = batter.swing();
        String judgement = judge(ball, swing);
        System.out.println(judgement);
        return judgement;
    }

    private static boolean getContinued() {
        boolean isContinued;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputContinuedString = readLine();
        isContinued = CONTINUED_STRING.equals(inputContinuedString);
        return isContinued;
    }

    private static String getString(boolean isContinued, Pitcher pitcher, String ball) {
        if (isContinued) {
            ball = pitcher.throwBall();
        }
        return ball;
    }
}
