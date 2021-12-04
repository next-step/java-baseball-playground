package referee;

import comparenumbers.CompareNumbers;

import java.util.List;

public class RefereeCheck {
    public String strikeBallNumber(List<Integer> comList, List<Integer> userList) {
        CompareNumbers compareNumbers = new CompareNumbers();
        int correctNumbers = compareNumbers.checkNumbers(comList, userList);
        int strike = compareNumbers.checkIndexNumber(comList, userList);
        int ball = correctNumbers - strike;

        if (correctNumbers == 0) {
            return "낫싱";
        }

        return strike + "스트라이크 " + ball + "볼";

    }
}
