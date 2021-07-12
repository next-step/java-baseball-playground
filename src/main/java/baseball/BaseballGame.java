package baseball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BaseballGame {


    private final List<Integer> you;

    BaseballGame() {
        this.you = BaseballGameFactory.createNumbers();
    }


    //String.charAt(int index)
    public int isStrike(List<Integer> me) {
        int strikeCount = 0;
        for (int i = 0; i < 3; i++) {
            if (me.get(i) == this.you.get(i)) {
                strikeCount += 1;
            }
        }
        return strikeCount;
    }

    public int isBall(List<Integer> me) {
        int inCount = me.stream()
                .filter(o -> this.you.contains(o))
                .mapToInt(o -> 1)
                .sum();
        return inCount - isStrike(me);
    }
}
