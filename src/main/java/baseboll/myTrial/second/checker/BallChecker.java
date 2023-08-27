package baseboll.myTrial.second.checker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BallChecker extends Checker {
    private int checkBall(String s, String answer){
        return answer.contains(s) ? 1 : 0;
    }

    public int countBall(String input, String answer, int strikeCount){
        String[] given = input.split("");
        Set<String> set = new HashSet<>(Arrays.asList(given));
        int count = 0;
        for (String s : set) {
            count += checkBall(s, answer);
        }
        if (strikeCount != 0) count -= strikeCount;
        return count;
    }
}
