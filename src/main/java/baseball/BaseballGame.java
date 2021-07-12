package baseball;

public class BaseballGame {
    //String.charAt(int index)
    public static int isStrike(String me, String you) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (me.charAt(i) == you.charAt(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public static int isBall(String me, String you) {
        int ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (me.charAt(i) == you.charAt(j) && i != j) {
                    ballCount += 1;
                }
            }
        } return ballCount;
    }

}
