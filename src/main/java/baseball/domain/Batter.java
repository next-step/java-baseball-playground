package baseball.domain;

import java.util.*;

import static baseball.domain.Pitcher.BALL_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Batter {
    String swing() {
        System.out.print("숫자를 입력해주세요 : ");
        String swingString = readLine();
        lengthCheck(swingString);
        validStringCheck(swingString);
        duplicateCheck(swingString);
        return swingString;
    }

    public void duplicateCheck(String swingString) {
        Set<String> set = new HashSet<>(Arrays.asList(swingString.split("")));
        if (set.size() != swingString.length()) {
            throw new IllegalArgumentException();
        }
    }

    public void validStringCheck(String swingString) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        String[] split = swingString.split("");
        for (String s : split) {
            containCheck(numbers, s);
        }
    }

    private void containCheck(ArrayList<String> numbers, String s) {
        if (!numbers.contains(s)) {
            throw new IllegalArgumentException();
        }
    }

    public void lengthCheck(String swingString) {
        if (swingString.length() != BALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
