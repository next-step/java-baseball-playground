package baseball;

public class BaseballGame {
    //String.charAt(int index)
    public static int play(String me, String you) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (me.charAt(i) == you.charAt(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }
}
